/*
 * Copyright 2015 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.ovsdb.lib.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.onosproject.ovsdb.lib.error.AbnormalSchemaException;
import org.onosproject.ovsdb.lib.error.JsonParsingException;
import org.onosproject.ovsdb.lib.error.UnknownResultException;
import org.onosproject.ovsdb.lib.jsonrpc.Callback;
import org.onosproject.ovsdb.lib.jsonrpc.JsonRpcResponse;
import org.onosproject.ovsdb.lib.message.OperationResult;
import org.onosproject.ovsdb.lib.message.RowUpdate;
import org.onosproject.ovsdb.lib.message.TableUpdate;
import org.onosproject.ovsdb.lib.message.TableUpdates;
import org.onosproject.ovsdb.lib.message.UpdateNotification;
import org.onosproject.ovsdb.lib.notation.Column;
import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.notation.UUID;
import org.onosproject.ovsdb.lib.operations.Operation;
import org.onosproject.ovsdb.lib.schema.ColumnSchema;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;
import org.onosproject.ovsdb.lib.schema.TableSchema;
import org.onosproject.ovsdb.lib.schema.type.ColumnTypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * JsonNode utility class. convert JsonNode into Object.
 */
public final class FromJsonUtil {

    private static final Logger log = LoggerFactory
            .getLogger(FromJsonUtil.class);

    private FromJsonUtil() {
    }

    /**
     * convert JsonNode into DatabaseSchema.
     * @param dbName database name
     * @param json the JsonNode of get_schema result
     * @return DatabaseSchema
     */
    public static DatabaseSchema jsonNodeToDbSchema(String dbName, JsonNode json) {
        if (!json.isObject() || !json.has("tables")) {
            throw new JsonParsingException(
                                           "bad DatabaseSchema root, expected \"tables\" as child but was not found");
        }
        if (!json.isObject() || !json.has("version")) {
            throw new JsonParsingException(
                                           "bad DatabaseSchema root, expected \"version\" as child but was not found");
        }

        String dbVersion = json.get("version").asText();

        Map<String, TableSchema> tables = new HashMap<>();
        for (Iterator<Map.Entry<String, JsonNode>> iter = json.get("tables")
                .fields(); iter.hasNext();) {
            Map.Entry<String, JsonNode> table = iter.next();
            tables.put(table.getKey(),
                       jsonNodeToTableSchema(table.getKey(), table.getValue()));
        }

        return new DatabaseSchema(dbName, dbVersion, tables);
    }

    /**
     * convert JsonNode into TableSchema.
     * @param tableName table name
     * @param json table JsonNode
     * @return TableSchema
     */
    private static TableSchema jsonNodeToTableSchema(String tableName,
                                                     JsonNode json) {

        if (!json.isObject() || !json.has("columns")) {
            throw new AbnormalSchemaException(
                                              "bad tableschema root, expected \"columns\" as child");
        }

        Map<String, ColumnSchema> columns = new HashMap<>();
        for (Iterator<Map.Entry<String, JsonNode>> iter = json.get("columns")
                .fields(); iter.hasNext();) {
            Map.Entry<String, JsonNode> column = iter.next();
            columns.put(column.getKey(),
                        jsonNodeToColumnSchema(column.getKey(),
                                               column.getValue()));
        }

        return new TableSchema(tableName, columns);
    }

    /**
     * convert JsonNode into ColumnSchema.
     * @param name column name
     * @param json JsonNode
     * @return ColumnSchema
     */
    private static ColumnSchema jsonNodeToColumnSchema(String name,
                                                       JsonNode json) {
        if (!json.isObject() || !json.has("type")) {
            throw new AbnormalSchemaException(
                                              "bad column schema root, expected \"type\" as child");
        }

        return new ColumnSchema(name,
                                ColumnTypeFactory.getColumnTypeFromJson(json
                                        .get("type")));
    }

    /**
     * convert JsonNode into the returnType of methods in OvsdbRPC class.
     * @param resultJsonNode the result JsonNode
     * @param methodName the method name of methods in OvsdbRPC class
     * @param objectMapper
     * @return
     */
    private static Object convertResultType(JsonNode resultJsonNode,
                                            String methodName,
                                            ObjectMapper objectMapper) {
        switch (methodName) {
        case "getSchema":
        case "monitor":
            return resultJsonNode;
        case "echo":
        case "listDbs":
            return objectMapper
                    .convertValue(resultJsonNode, objectMapper.getTypeFactory()
                            .constructParametricType(List.class, String.class));
        case "transact":
            return objectMapper
                    .convertValue(resultJsonNode,
                                  objectMapper
                                          .getTypeFactory()
                                          .constructParametricType(List.class,
                                                                   JsonNode.class));
        default:
            throw new UnknownResultException("Don't know how to handle this");
        }
    }

    /**
     * convert JsonNode into the returnType of methods in OvsdbRPC class.
     * @param jsonNode the result JsonNode
     * @param methodName the method name of methods in OvsdbRPC class
     * @return Object
     * @throws NoSuchMethodException
     */
    public static Object jsonResultParser(JsonNode jsonNode, String methodName)
            throws NoSuchMethodException {
        ObjectMapper objectMapper = ObjectMapperUtil.getObjectMapper();
        JsonNode error = jsonNode.get("error");
        if (error != null && !error.isNull()) {
            log.error("Error : {}", error.toString());
        }
        JsonNode resultJsonNode = jsonNode.get("result");
        Object result = convertResultType(resultJsonNode, methodName,
                                          objectMapper);
        return result;
    }

    /**
     * When monitor the ovsdb tables, if a table update, ovs send update
     * notification, then call callback function.
     * @param jsonNode the result JsonNode
     * @param callback the callback function
     */
    public static void jsonCallbackRequestParser(JsonNode jsonNode,
                                                 Callback callback) {
        ObjectMapper objectMapper = ObjectMapperUtil.getObjectMapper();
        JsonNode params = jsonNode.get("params");
        Object param = null;
        String methodName = jsonNode.get("method").asText();
        switch (methodName) {
        case "update":
            param = objectMapper.convertValue(params, UpdateNotification.class);
            callback.update((UpdateNotification) param);
            break;
        default:
            throw new UnknownResultException("Cannot handle this method: "
                    + methodName);
        }
    }

    /**
     * Ovs send echo request to keep the heart, need we return echo result.
     * @param the result JsonNode
     * @return JsonRpcResponse String
     */
    public static String getEchoRequestStr(JsonNode jsonNode) {
        ObjectMapper objectMapper = ObjectMapperUtil.getObjectMapper();
        String str = null;
        if (jsonNode.get("method").asText().equals("echo")) {
            JsonRpcResponse response = new JsonRpcResponse(jsonNode.get("id")
                    .asText(), null);
            try {
                str = objectMapper.writeValueAsString(response);
            } catch (JsonProcessingException e) {
                log.error("Exception while processing JSON string " + str, e);
            }
        }
        return str;
    }

    /**
     * Convert the Operation result into List<OperationResult> .
     * @param input the List of JsonNode
     * @param operations the List of Operation
     * @return the List of OperationResult
     */
    public static List<OperationResult> jsonNodeToOperationResult(List<JsonNode> input,
                                                                  List<Operation> operations) {
        ObjectMapper objectMapper = ObjectMapperUtil.getObjectMapper(false);
        List<OperationResult> operationResults = new ArrayList<OperationResult>();
        OperationResult or = new OperationResult();
        for (int i = 0; i < input.size(); i++) {
            JsonNode jsonNode = input.get(i);
            Operation operation = operations.get(i);
            if (jsonNode != null && jsonNode.size() > 0) {
                if (i > operations.size() || operation.getOp() != "select") {
                    or = objectMapper.convertValue(jsonNode,
                                                   OperationResult.class);
                } else {
                    or.setRows(createRows(operation.getTableSchema(), jsonNode));
                }
            }
            operationResults.add(or);
        }
        return operationResults;
    }

    /**
     * Convert Operation JsonNode into Rows.
     * @param tableSchema TableSchema entity
     * @param rowsNode JsonNode
     * @return ArrayList<Row> the List of Row
     */
    private static ArrayList<Row> createRows(TableSchema tableSchema,
                                             JsonNode rowsNode) {
        ArrayList<Row> rows = Lists.newArrayList();
        for (JsonNode rowNode : rowsNode.get("rows")) {
            rows.add(createRow(tableSchema, rowNode));
        }
        return rows;
    }

    /**
     * convert the params of Update Notification into TableUpdates.
     * @param updatesJson the params of Update Notification
     * @param dbSchema DatabaseSchema entity
     * @return TableUpdates
     */
    public static TableUpdates jsonNodeToTableUpdates(JsonNode updatesJson,
                                                      DatabaseSchema dbSchema) {
        Map<String, TableUpdate> tableUpdateMap = Maps.newHashMap();
        for (Iterator<Map.Entry<String, JsonNode>> itr = updatesJson.fields(); itr
                .hasNext();) {
            Map.Entry<String, JsonNode> entry = itr.next();
            TableSchema tableSchema = dbSchema.getTableSchema(entry.getKey());
            TableUpdate tableUpdate = jsonNodeToTableUpdate(tableSchema,
                                                            entry.getValue());
            tableUpdateMap.put(entry.getKey(), tableUpdate);
        }
        return TableUpdates.tableUpdates(tableUpdateMap);
    }

    /**
     * convert the params of Update Notification into TableUpdate.
     * @param tableSchema TableSchema entity
     * @param value the table-update in params of Update Notification
     * @return TableUpdate
     */
    public static TableUpdate jsonNodeToTableUpdate(TableSchema tableSchema,
                                                    JsonNode value) {
        Map<UUID, RowUpdate> rows = Maps.newHashMap();
        Iterator<Entry<String, JsonNode>> fields = value.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> idOldNew = fields.next();
            String uuidStr = idOldNew.getKey();
            UUID uuid = UUID.uuid(uuidStr);
            JsonNode newR = idOldNew.getValue().get("new");
            JsonNode oldR = idOldNew.getValue().get("old");
            Row newRow = newR != null ? createRow(tableSchema, newR) : null;
            Row oldRow = oldR != null ? createRow(tableSchema, oldR) : null;
            RowUpdate rowUpdate = new RowUpdate(uuid, oldRow, newRow);
            rows.put(uuid, rowUpdate);
        }
        return TableUpdate.tableUpdate(rows);
    }

    /**
     * Convert Operation JsonNode into Row.
     * @param tableSchema TableSchema entity
     * @param rowNode JsonNode
     * @return Row
     */
    private static Row createRow(TableSchema tableSchema, JsonNode rowNode) {
        List<Column> columns = Lists.newArrayList();
        for (Iterator<Map.Entry<String, JsonNode>> iter = rowNode.fields(); iter
                .hasNext();) {
            Map.Entry<String, JsonNode> next = iter.next();
            ColumnSchema schema = tableSchema.getColumnSchema(next.getKey());
            if (schema != null) {
                Object o = schema.type().getValueFromJson(next.getValue());
                columns.add(new Column(schema, o));
            }
        }
        return new Row(tableSchema, columns);
    }

}
