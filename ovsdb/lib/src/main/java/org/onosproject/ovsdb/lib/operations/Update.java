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
package org.onosproject.ovsdb.lib.operations;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.onosproject.ovsdb.lib.notation.Column;
import org.onosproject.ovsdb.lib.notation.Condition;
import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.schema.ColumnSchema;
import org.onosproject.ovsdb.lib.schema.TableSchema;
import org.onosproject.ovsdb.lib.utils.TransValueUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;

/**
 * update operation.Refer to RFC 7047 Section 5.2.
 */
public class Update implements Operation {

    @JsonIgnore
    private final TableSchema tableSchema;
    private final String op;
    private final Map<String, Object> row;
    private final List<Condition> where;

    /**
     * Constructs a Update object.
     * @param schema TableSchema entity
     * @param row Row entity
     * @param where the List of Condition entity
     */
    public Update(TableSchema schema, Row row, List<Condition> where) {
        checkNotNull(schema, "TableSchema is not null");
        checkNotNull(row, "row is not null");
        checkNotNull(where, "where is not null");
        this.tableSchema = schema;
        this.op = Operations.UPDATE.getName();
        this.row = Maps.newHashMap();
        this.where = where;
        generateOperationRow(row);
    }

    /**
     * Row entity convert into the row format of update operation. Refer to RFC
     * 7047 Section 5.2.
     * @param row Row entity
     */
    private void generateOperationRow(Row row) {
        Collection<Column> columns = row.getColumns();
        for (Column column : columns) {
            ColumnSchema columnSchema = column.schema();
            Object value = column.data();
            Object untypedValue = TransValueUtil.getFormatData(value);
            this.row.put(columnSchema.name(), untypedValue);
        }
    }

    /**
     * Returns the row member of update operation.
     * @return the row member of update operation
     */
    public Map<String, Object> getRow() {
        return row;
    }

    /**
     * Returns the where member of update operation.
     * @return the where member of update operation
     */
    public List<Condition> getWhere() {
        return where;
    }

    @Override
    public String getOp() {
        return op;
    }

    @Override
    public TableSchema getTableSchema() {
        return tableSchema;
    }

    /**
     * For the use of serialization.
     * @return the table member of update operation
     */
    @JsonProperty
    public String getTable() {
        return (tableSchema == null) ? null : tableSchema.name();
    }
}
