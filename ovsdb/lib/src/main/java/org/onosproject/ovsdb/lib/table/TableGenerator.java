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
package org.onosproject.ovsdb.lib.table;

import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;

/**
 * Table generator.
 */
public final class TableGenerator {

    /**
     * Ovsdb table name.
     */
    public enum OvsdbTable {
        INTERFACE, BRIDGE, CONTROLLER, PORT, OPENVSWITCH, FLWTABLE, QOS, QUEUE,
        MIRROR, MANAGER, NETFLOW, SSL, SFLOW, IPFIX, FLOWSAMPLECOLLECTORSET
    }

    private TableGenerator() {
    }

    /**
     * Create table.
     * @param dbSchema DatabaseSchema entity
     * @param tableName table name
     * @return
     */
    public static Object createTable(DatabaseSchema dbSchema,
                                     OvsdbTable tableName) {
        Row row = new Row();
        return generateTable(dbSchema, row, tableName);
    }

    /**
     * Get table from Row.
     * @param dbSchema DatabaseSchema entity
     * @param row Row entity
     * @param tableName table name
     * @return
     */
    public static Object getTable(DatabaseSchema dbSchema, Row row,
                                  OvsdbTable tableName) {
        return generateTable(dbSchema, row, tableName);
    }

    /**
     * Generate the table by table name.
     * @param dbSchema DatabaseSchema entity
     * @param row Row entity
     * @param tableName table name
     * @return
     */
    private static Object generateTable(DatabaseSchema dbSchema, Row row,
                                        OvsdbTable tableName) {
        switch (tableName) {
        case INTERFACE:
            return new Interface(dbSchema, row);
        case BRIDGE:
            return new Bridge(dbSchema, row);
        case CONTROLLER:
            return new Controller(dbSchema, row);
        case PORT:
            return new Port(dbSchema, row);
        case OPENVSWITCH:
            return new OpenVSwitch(dbSchema, row);
        case FLWTABLE:
            return new FlowTable(dbSchema, row);
        case QOS:
            return new Qos(dbSchema, row);
        case QUEUE:
            return new Queue(dbSchema, row);
        case MIRROR:
            return new Mirror(dbSchema, row);
        case MANAGER:
            return new Manager(dbSchema, row);
        case NETFLOW:
            return new NetFlow(dbSchema, row);
        case SSL:
            return new SSL(dbSchema, row);
        case SFLOW:
            return new SFlow(dbSchema, row);
        case IPFIX:
            return new IPFIX(dbSchema, row);
        case FLOWSAMPLECOLLECTORSET:
            return new FlowSampleCollectorSet(dbSchema, row);
        default:
            return null;
        }
    }
}
