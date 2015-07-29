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
import java.util.Set;

import org.onosproject.ovsdb.lib.notation.Column;
import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.notation.UUID;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;
import org.onosproject.ovsdb.lib.tableservice.AbstractOvsdbTableService;
import org.onosproject.ovsdb.lib.tableservice.ColumnDescription;

/**
 * This class provides operations of Mirror Table.
 */
public class Mirror extends AbstractOvsdbTableService {

    /**
     * Constructs a Mirror object. Generate Mirror Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public Mirror(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "Mirror", "1.0.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("Mirror"));
        }
    }

    /**
     * Get the Column entity which column name is "name" from the Row entity of
     * attributes.
     * @return the Column entity which column name is "name"
     * @throws Throwable
     */
    public Column getNameColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("name",
                                                             "getNameColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "name" to the Row entity of
     * attributes.
     * @param name the column data which column name is "name"
     * @throws Throwable
     */
    public void setName(Set<String> name) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("name", "setName",
                                                             "1.0.0");
        super.setDataHandler(columndesc, name);
    }

    /**
     * Get the column data which column name is "name" from the Row entity of
     * attributes.
     * @return the column data which column name is "name"
     * @throws Throwable
     */
    public Set<String> getName() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("name", "getName",
                                                             "1.0.0");
        return (Set<String>) super.getColumnHandler(columndesc);
    }

    /**
     * Get the Column entity which column name is "select_src_port" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "select_src_port"
     * @throws Throwable
     */
    public Column getSelectSrcPortColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "select_src_port",
                                                             "getSelectSrcPortColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "select_src_port" to the Row
     * entity of attributes.
     * @param name the column data which column name is "select_src_port"
     * @throws Throwable
     */
    public void setSelectSrcPort(Set<UUID> selectSrcPort) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "select_src_port",
                                                             "setSelectSrcPort",
                                                             "1.0.0");
        super.setDataHandler(columndesc, selectSrcPort);
    }

    /**
     * Get the Column entity which column name is "select_dst_port" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "select_dst_port"
     * @throws Throwable
     */
    public Column getSelectDstPortColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "select_dst_port",
                                                             "getSelectDstPortColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "select_dst_port" to the Row
     * entity of attributes.
     * @param name the column data which column name is "select_dst_port"
     * @throws Throwable
     */
    public void setSelectDstPort(Set<UUID> selectDstPrt) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "select_dst_port",
                                                             "setSelectDstPort",
                                                             "1.0.0");
        super.setDataHandler(columndesc, selectDstPrt);
    }

    /**
     * Get the Column entity which column name is "select_vlan" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "select_vlan"
     * @throws Throwable
     */
    public Column getSelectVlanColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "select_vlan",
                                                             "getSelectVlanColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "select_vlan" to the Row entity
     * of attributes.
     * @param name the column data which column name is "select_vlan"
     * @throws Throwable
     */
    public void setSelectVlan(Set<Long> selectVlan) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("select_vlan",
                                                             "setSelectVlan",
                                                             "1.0.0");
        super.setDataHandler(columndesc, selectVlan);
    }

    /**
     * Get the Column entity which column name is "output_port" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "output_port"
     * @throws Throwable
     */
    public Column getOutputPortColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "output_port",
                                                             "getOutputPortColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "output_port" to the Row entity
     * of attributes.
     * @param name the column data which column name is "output_port"
     * @throws Throwable
     */
    public void setOutputPort(Set<UUID> outputPort) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("output_port",
                                                             "setOutputPort",
                                                             "1.0.0");
        super.setDataHandler(columndesc, outputPort);
    }

    /**
     * Get the Column entity which column name is "output_vlan" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "output_vlan"
     * @throws Throwable
     */
    public Column getOutputVlanColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "output_vlan",
                                                             "getOutputVlanColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "output_vlan" to the Row entity
     * of attributes.
     * @param name the column data which column name is "output_vlan"
     * @throws Throwable
     */
    public void setOutputVlan(Set<Long> outputVlan) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("output_vlan",
                                                             "setOutputVlan",
                                                             "1.0.0");
        super.setDataHandler(columndesc, outputVlan);
    }

    /**
     * Get the Column entity which column name is "statistics" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "statistics"
     * @throws Throwable
     */
    public Column getStatisticsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "statistics",
                                                             "getStatisticsColumn",
                                                             "6.4.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "statistics" to the Row entity
     * of attributes.
     * @param name the column data which column name is "statistics"
     * @throws Throwable
     */
    public void setStatistics(Map<String, Long> statistics) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("statistics",
                                                             "setStatistics",
                                                             "6.4.0");
        super.setDataHandler(columndesc, statistics);
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
                                                             "1.0.0");
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
                                                             "1.0.0");
        super.setDataHandler(columndesc, externalIds);
    }

    /**
     * Get the Column entity which column name is "select_all" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "select_all"
     * @throws Throwable
     */
    public Column getSelectAllColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "select_all",
                                                             "getSelectAllColumn",
                                                             "6.2.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "select_all" to the Row entity
     * of attributes.
     * @param name the column data which column name is "select_all"
     * @throws Throwable
     */
    public void setSelectAll(Boolean selectAll) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("select_all",
                                                             "setSelectAll",
                                                             "6.2.0");
        super.setDataHandler(columndesc, selectAll);
    }
}
