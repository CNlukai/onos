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

import java.util.Map;

import org.onosproject.ovsdb.lib.notation.Column;
import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.notation.UUID;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;
import org.onosproject.ovsdb.lib.tableservice.AbstractOvsdbTableService;
import org.onosproject.ovsdb.lib.tableservice.ColumnDescription;

/**
 * This class provides operations of FlowSampleCollectorSet Table.
 */
public class FlowSampleCollectorSet extends AbstractOvsdbTableService {

    /**
     * Constructs a FlowSampleCollectorSet object. Generate
     * FlowSampleCollectorSet Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public FlowSampleCollectorSet(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "Flow_Sample_Collector_Set", "7.1.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("Flow_Sample_Collector_Set"));
        }
    }

    /**
     * Get the Column entity which column name is "id" from the Row entity of
     * attributes.
     * @return the Column entity which column name is "id"
     * @throws Throwable
     */
    public Column getIdColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("id",
                                                             "getIdColumn",
                                                             "7.1.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "id" to the Row entity of
     * attributes.
     * @param name the column data which column name is "id"
     * @throws Throwable
     */
    public void setId(Long id) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("id", "setId",
                                                             "7.1.0");
        super.setDataHandler(columndesc, id);
    }

    /**
     * Get the Column entity which column name is "bridge" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "bridge"
     * @throws Throwable
     */
    public Column getBridgeColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("bridge",
                                                             "getBridgeColumn",
                                                             "7.1.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "bridge" to the Row entity of
     * attributes.
     * @param name the column data which column name is "bridge"
     * @throws Throwable
     */
    public void setBridge(UUID bridge) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("bridge",
                                                             "setBridge",
                                                             "7.1.0");
        super.setDataHandler(columndesc, bridge);
    }

    /**
     * Get the Column entity which column name is "ipfix" from the Row entity of
     * attributes.
     * @return the Column entity which column name is "ipfix"
     * @throws Throwable
     */
    public Column getIpfixColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("ipfix",
                                                             "getIpfixColumn",
                                                             "7.1.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "ipfix" to the Row entity of
     * attributes.
     * @param name the column data which column name is "ipfix"
     * @throws Throwable
     */
    public void setIpfix(UUID ipfix) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("ipfix",
                                                             "setIpfix",
                                                             "7.1.0");
        super.setDataHandler(columndesc, ipfix);
    }

    /**
     * Get the Column entity which column name is "external_ids" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "external_ids"
     * @throws Throwable
     */
    public Column getExternalIdsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "external_ids",
                                                             "getExternalIdsColumn",
                                                             "7.1.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "external_ids" to the Row entity
     * of attributes.
     * @param name the column data which column name is "external_ids"
     * @throws Throwable
     */
    public void setExternalIds(Map<String, String> externalIds)
            throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("external_ids",
                                                             "setExternalIds",
                                                             "7.1.0");
        super.setDataHandler(columndesc, externalIds);
    }
}
