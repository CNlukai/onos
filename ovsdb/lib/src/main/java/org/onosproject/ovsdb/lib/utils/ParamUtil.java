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

import java.util.List;
import java.util.Set;

import org.onosproject.ovsdb.lib.message.MonitorRequest;
import org.onosproject.ovsdb.lib.message.MonitorSelect;
import org.onosproject.ovsdb.lib.operations.Operation;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;
import org.onosproject.ovsdb.lib.schema.TableSchema;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Params utility class. Params of the request object, refer to RFC 7047 Section
 * 4.1.
 */
public final class ParamUtil {

    private ParamUtil() {
    }

    /**
     * Returns MonitorRequest, refer to RFC 7047 Section 4.1.5.
     * @param tableSchema entity
     * @return MonitorRequest
     */
    private static MonitorRequest getAllColumnsMonitorRequest(TableSchema tableSchema) {
        String tableName = tableSchema.name();
        Set<String> columns = tableSchema.getColumnNames();
        MonitorSelect select = new MonitorSelect(true, true, true, true);
        MonitorRequest monitorRequest = new MonitorRequest(tableName, columns,
                                                           select);
        return monitorRequest;
    }

    /**
     * Returns params of monitor method, refer to RFC 7047 Section 4.1.5.
     * @param monotorId <json-value>, refer to RFC 7047 Section 4.1.5.
     * @param dbSchema DatabaseSchema entity
     * @return List<Object> params
     */
    public static List<Object> getMonitorParams(String monotorId,
                                                DatabaseSchema dbSchema) {
        Set<String> tables = dbSchema.getTableNames();
        List<MonitorRequest> monitorRequests = Lists.newArrayList();
        for (String tableName : tables) {
            TableSchema tableSchema = dbSchema.getTableSchema(tableName);
            monitorRequests.add(getAllColumnsMonitorRequest(tableSchema));
        }
        ImmutableMap<String, MonitorRequest> reqMap = Maps
                .uniqueIndex(monitorRequests,
                             new Function<MonitorRequest, String>() {
                                 @Override
                                 public String apply(MonitorRequest input) {
                                     return input.getTableName();
                                 }
                             });
        return Lists.<Object>newArrayList(dbSchema.name(), monotorId,
                                           reqMap);
    }

    /**
     * Returns params of transact method, refer to RFC 7047 Section 4.1.3.
     * @param dbSchema DatabaseSchema entity
     * @param operations <operation>*, refer to RFC 7047 Section 4.1.3.
     * @return List<Object> params
     */
    public static List<Object> getTransactParams(DatabaseSchema dbSchema,
                                                 List<Operation> operations) {
        List<Object> lists = Lists.newArrayList((Object) dbSchema.name());
        lists.addAll(operations);
        return lists;
    }
}
