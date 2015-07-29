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
 * This class provides operations of Bridge Table.
 */
public class Bridge extends AbstractOvsdbTableService {

    /**
     * Constructs a Bridge object. Generate Bridge Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public Bridge(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "Bridge", "1.0.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("Bridge"));
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
    public void setName(String name) throws Throwable {
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
    public String getName() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("name", "getName",
                                                             "1.0.0");
        return (String) super.getDataHandler(columndesc);
    }

    /**
     * Get the Column entity which column name is "datapath_type" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "datapath_type"
     * @throws Throwable
     */
    public Column getDatapathTypeColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "datapath_type",
                                                             "getDatapathTypeColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "datapath_type" to the Row
     * entity of attributes.
     * @param datapathType the column data which column name is "datapath_type"
     * @throws Throwable
     */
    public void setDatapathType(String datapathType) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("datapath_type",
                                                             "setDatapathType",
                                                             "1.0.0");
        super.setDataHandler(columndesc, datapathType);
    }

    /**
     * Get the Column entity which column name is "datapath_id" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "datapath_id"
     * @throws Throwable
     */
    public Column getDatapathIdColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "datapath_id",
                                                             "getDatapathIdColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "datapath_id" to the Row entity
     * of attributes.
     * @param datapathType the column data which column name is "datapath_id"
     * @throws Throwable
     */
    public void setDatapathId(Set<String> datapathId) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("datapath_id",
                                                             "setDatapathId",
                                                             "1.0.0");
        super.setDataHandler(columndesc, datapathId);
    }

    /**
     * Get the Column entity which column name is "stpenable" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "stpenable"
     * @throws Throwable
     */
    public Column getStpEnableColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "stpenable",
                                                             "getStpEnableColumn",
                                                             "6.2.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "stpenable" to the Row entity of
     * attributes.
     * @param datapathType the column data which column name is "stpenable"
     * @throws Throwable
     */
    public void setStpEnable(Boolean stpenable) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("stpenable",
                                                             "setStpEnable",
                                                             "6.2.0");
        super.setDataHandler(columndesc, stpenable);
    }

    /**
     * Get the Column entity which column name is "ports" from the Row entity of
     * attributes.
     * @return the Column entity which column name is "ports"
     * @throws Throwable
     */
    public Column getPortsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("ports",
                                                             "getPortsColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "ports" to the Row entity of
     * attributes.
     * @param datapathType the column data which column name is "ports"
     * @throws Throwable
     */
    public void setPorts(Set<UUID> ports) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("ports",
                                                             "setPorts",
                                                             "1.0.0");
        super.setDataHandler(columndesc, ports);
    }

    /**
     * Get the Column entity which column name is "mirrors" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "mirrors"
     * @throws Throwable
     */
    public Column getMirrorsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "mirrors",
                                                             "getMirrorsColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "mirrors" to the Row entity of
     * attributes.
     * @param datapathType the column data which column name is "mirrors"
     * @throws Throwable
     */
    public void setMirrors(Set<UUID> mirrors) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("mirrors",
                                                             "setMirrors",
                                                             "1.0.0");
        super.setDataHandler(columndesc, mirrors);
    }

    /**
     * Get the Column entity which column name is "netflow" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "netflow"
     * @throws Throwable
     */
    public Column getNetflowColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "netflow",
                                                             "getNetflowColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "netflow" to the Row entity of
     * attributes.
     * @param datapathType the column data which column name is "netflow"
     * @throws Throwable
     */
    public void setNetflow(Set<UUID> netflow) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("netflow",
                                                             "setNetflow",
                                                             "1.0.0");
        super.setDataHandler(columndesc, netflow);
    }

    /**
     * Get the Column entity which column name is "sflow" from the Row entity of
     * attributes.
     * @return the Column entity which column name is "sflow"
     * @throws Throwable
     */
    public Column getSflowColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("sflow",
                                                             "getSflowColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "sflow" to the Row entity of
     * attributes.
     * @param datapathType the column data which column name is "sflow"
     * @throws Throwable
     */
    public void setSflow(Set<UUID> sflow) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("sflow",
                                                             "setSflow",
                                                             "1.0.0");
        super.setDataHandler(columndesc, sflow);
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
     * @param datapathType the column data which column name is "ipfix"
     * @throws Throwable
     */
    public void setIpfix(Set<UUID> ipfix) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("ipfix",
                                                             "setIpfix",
                                                             "7.1.0");
        super.setDataHandler(columndesc, ipfix);
    }

    /**
     * Get the Column entity which column name is "controller" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "controller"
     * @throws Throwable
     */
    public Column getControllerColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "controller",
                                                             "getControllerColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "controller" to the Row entity
     * of attributes.
     * @param datapathType the column data which column name is "controller"
     * @throws Throwable
     */
    public void setController(Set<UUID> controller) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("controller",
                                                             "setController",
                                                             "1.0.0");
        super.setDataHandler(columndesc, controller);
    }

    /**
     * Get the Column entity which column name is "protocols" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "protocols"
     * @throws Throwable
     */
    public Column getProtocolsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "protocols",
                                                             "getProtocolsColumn",
                                                             "6.11.1");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "protocols" to the Row entity of
     * attributes.
     * @param datapathType the column data which column name is "protocols"
     * @throws Throwable
     */
    public void setProtocols(Set<String> protocols) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("protocols",
                                                             "setProtocols",
                                                             "6.11.1");
        super.setDataHandler(columndesc, protocols);
    }

    /**
     * Get the Column entity which column name is "fail_mode" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "fail_mode"
     * @throws Throwable
     */
    public Column getFailModeColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "fail_mode",
                                                             "getFailModeColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "fail_mode" to the Row entity of
     * attributes.
     * @param datapathType the column data which column name is "fail_mode"
     * @throws Throwable
     */
    public void setFailMode(Set<String> failMode) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("fail_mode",
                                                             "setFailMode",
                                                             "1.0.0");
        super.setDataHandler(columndesc, failMode);
    }

    /**
     * Get the Column entity which column name is "status" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "status"
     * @throws Throwable
     */
    public Column getStatusColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("status",
                                                             "getStatusColumn",
                                                             "6.2.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "status" to the Row entity of
     * attributes.
     * @param datapathType the column data which column name is "status"
     * @throws Throwable
     */
    public void setStatus(Map<String, String> status) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("status",
                                                             "setStatus",
                                                             "6.2.0");
        super.setDataHandler(columndesc, status);
    }

    /**
     * Get the Column entity which column name is "other_config" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "other_config"
     * @throws Throwable
     */
    public Column getOtherConfigColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "other_config",
                                                             "getOtherConfigColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "other_config" to the Row entity
     * of attributes.
     * @param datapathType the column data which column name is "other_config"
     * @throws Throwable
     */
    public void setOtherConfig(Map<String, String> otherConfig)
            throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("other_config",
                                                             "setOtherConfig",
                                                             "1.0.0");
        super.setDataHandler(columndesc, otherConfig);
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
     * @param datapathType the column data which column name is "external_ids"
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
     * Get the Column entity which column name is "flood_vlans" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "flood_vlans"
     * @throws Throwable
     */
    public Column getFloodVlansColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "flood_vlans",
                                                             "getFloodVlansColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "flood_vlans" to the Row entity
     * of attributes.
     * @param datapathType the column data which column name is "flood_vlans"
     * @throws Throwable
     */
    public void setFloodVlans(Set<Long> vlans) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("flood_vlans",
                                                             "setFloodVlans",
                                                             "1.0.0");
        super.setDataHandler(columndesc, vlans);
    }

    /**
     * Get the Column entity which column name is "flow_tables" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "flow_tables"
     * @throws Throwable
     */
    public Column getFlowTablesColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "flow_tables",
                                                             "getFlowTablesColumn",
                                                             "6.5.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "flow_tables" to the Row entity
     * of attributes.
     * @param datapathType the column data which column name is "flow_tables"
     * @throws Throwable
     */
    public void setFlowTables(Map<Long, UUID> flowTables) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("flow_tables",
                                                             "setFlowTables",
                                                             "6.5.0");
        super.setDataHandler(columndesc, flowTables);
    }

}
