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
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;
import org.onosproject.ovsdb.lib.tableservice.AbstractOvsdbTableService;
import org.onosproject.ovsdb.lib.tableservice.ColumnDescription;

/**
 * This class provides operations of Interface Table.
 */
public class Interface extends AbstractOvsdbTableService {

    /**
     * Constructs a Interface object. Generate Interface Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public Interface(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "Interface", "1.0.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("Interface"));
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
     * Get the Column entity which column name is "type" from the Row entity of
     * attributes.
     * @return the Column entity which column name is "type"
     * @throws Throwable
     */
    public Column getTypeColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("type",
                                                             "getTypeColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "type" to the Row entity of
     * attributes.
     * @param name the column data which column name is "type"
     * @throws Throwable
     */
    public void setType(String type) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("type", "setType",
                                                             "1.0.0");
        super.setDataHandler(columndesc, type);
    }

    /**
     * Get the Column entity which column name is "options" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "options"
     * @throws Throwable
     */
    public Column getOptionsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "options",
                                                             "getOptionsColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "options" to the Row entity of
     * attributes.
     * @param name the column data which column name is "options"
     * @throws Throwable
     */
    public void setOptions(Map<String, String> options) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("options",
                                                             "setOptions",
                                                             "1.0.0");
        super.setDataHandler(columndesc, options);
    }

    /**
     * Get the Column entity which column name is "ingress_policing_rate" from
     * the Row entity of attributes.
     * @return the Column entity which column name is "ingress_policing_rate"
     * @throws Throwable
     */
    public Column getIngressPolicingRateColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "ingress_policing_rate",
                                                             "getIngressPolicingRateColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "ingress_policing_rate" to the
     * Row entity of attributes.
     * @param name the column data which column name is "ingress_policing_rate"
     * @throws Throwable
     */
    public void setIngressPolicingRate(Set<Long> ingressPolicingRate)
            throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "ingress_policing_rate",
                                                             "setIngressPolicingRate",
                                                             "1.0.0");
        super.setDataHandler(columndesc, ingressPolicingRate);
    }

    /**
     * Get the Column entity which column name is "ingress_policing_burst" from
     * the Row entity of attributes.
     * @return the Column entity which column name is "ingress_policing_burst"
     * @throws Throwable
     */
    public Column getIngressPolicingBurstColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "ingress_policing_burst",
                                                             "getIngressPolicingBurstColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "ingress_policing_burst" to the
     * Row entity of attributes.
     * @param name the column data which column name is "ingress_policing_burst"
     * @throws Throwable
     */
    public void setIngressPolicingBurst(Set<Long> ingressPolicingBurst)
            throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "ingress_policing_burst",
                                                             "setIngressPolicingBurst",
                                                             "1.0.0");
        super.setDataHandler(columndesc, ingressPolicingBurst);
    }

    /**
     * Get the Column entity which column name is "mac_in_use" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "mac_in_use"
     * @throws Throwable
     */
    public Column getMacInUseColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "mac_in_use",
                                                             "getMacInUseColumn",
                                                             "7.1.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "mac_in_use" to the Row entity
     * of attributes.
     * @param name the column data which column name is "mac_in_use"
     * @throws Throwable
     */
    public void setMacInUse(Set<String> macInUse) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("mac_in_use",
                                                             "setMacInUse",
                                                             "7.1.0");
        super.setDataHandler(columndesc, macInUse);
    }

    /**
     * Get the Column entity which column name is "mac" from the Row entity of
     * attributes.
     * @return the Column entity which column name is "mac"
     * @throws Throwable
     */
    public Column getMacColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("mac",
                                                             "getMacColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "mac" to the Row entity of
     * attributes.
     * @param name the column data which column name is "mac"
     * @throws Throwable
     */
    public void setMac(Set<String> mac) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("mac", "setMac",
                                                             "1.0.0");
        super.setDataHandler(columndesc, mac);
    }

    /**
     * Get the Column entity which column name is "ifindex" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "ifindex"
     * @throws Throwable
     */
    public Column getIfIndexColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "ifindex",
                                                             "getIfIndexColumn",
                                                             "7.2.1");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "ifindex" to the Row entity of
     * attributes.
     * @param name the column data which column name is "ifindex"
     * @throws Throwable
     */
    public void setIfIndex(Long ifIndex) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("ifindex",
                                                             "setIfIndex",
                                                             "7.2.1");
        super.setDataHandler(columndesc, ifIndex);
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
     * Get the Column entity which column name is "ofport" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "ofport"
     * @throws Throwable
     */
    public Column getOpenFlowPortColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "ofport",
                                                             "getOpenFlowPortColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "ofport" to the Row entity of
     * attributes.
     * @param name the column data which column name is "ofport"
     * @throws Throwable
     */
    public void setOpenFlowPort(Set<Long> openFlowPort) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("ofport",
                                                             "setOpenFlowPort",
                                                             "1.0.0");
        super.setDataHandler(columndesc, openFlowPort);
    }

    /**
     * Get the Column entity which column name is "ofport_request" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "ofport_request"
     * @throws Throwable
     */
    public Column getOpenFlowPortRequestColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "ofport_request",
                                                             "getOpenFlowPortRequestColumn",
                                                             "6.2.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "ofport_request" to the Row
     * entity of attributes.
     * @param name the column data which column name is "ofport_request"
     * @throws Throwable
     */
    public void setOpenFlowPortRequest(String openFlowPortRequest)
            throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "ofport_request",
                                                             "setOpenFlowPortRequest",
                                                             "6.2.0");
        super.setDataHandler(columndesc, openFlowPortRequest);
    }

    /**
     * Get the Column entity which column name is "bfd" from the Row entity of
     * attributes.
     * @return the Column entity which column name is "bfd"
     * @throws Throwable
     */
    public Column getBfdColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("bfd",
                                                             "getBfdColumn",
                                                             "7.2.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "bfd" to the Row entity of
     * attributes.
     * @param name the column data which column name is "bfd"
     * @throws Throwable
     */
    public void setBfd(Map<String, String> bfd) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("bfd", "setBfd",
                                                             "7.2.0");
        super.setDataHandler(columndesc, bfd);
    }

    /**
     * Get the Column entity which column name is "bfd_status" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "bfd_status"
     * @throws Throwable
     */
    public Column getBfdStatusColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "bfd_status",
                                                             "getBfdStatusColumn",
                                                             "7.2.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "bfd_status" to the Row entity
     * of attributes.
     * @param name the column data which column name is "bfd_status"
     * @throws Throwable
     */
    public void setBfdStatus(Map<String, String> bfdStatus) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("bfd_status",
                                                             "setBfdStatus",
                                                             "7.2.0");
        super.setDataHandler(columndesc, bfdStatus);
    }

    /**
     * Get the Column entity which column name is "monitor" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "monitor"
     * @throws Throwable
     */
    public Column getMonitorColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "monitor",
                                                             "getMonitorColumn",
                                                             "1.0.0", "3.5.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "monitor" to the Row entity of
     * attributes.
     * @param name the column data which column name is "monitor"
     * @throws Throwable
     */
    public void setMonitor(String monitor) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("monitor",
                                                             "setMonitor",
                                                             "1.0.0", "3.5.0");
        super.setDataHandler(columndesc, monitor);
    }

    /**
     * Get the Column entity which column name is "cfm_mpid" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "cfm_mpid"
     * @throws Throwable
     */
    public Column getCfmMpidColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cfm_mpid",
                                                             "getCfmMpidColumn",
                                                             "4.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "cfm_mpid" to the Row entity of
     * attributes.
     * @param name the column data which column name is "cfm_mpid"
     * @throws Throwable
     */
    public void setCfmMpid(Set<Long> cfmMpid) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("cfm_mpid",
                                                             "setCfmMpid",
                                                             "4.0.0");
        super.setDataHandler(columndesc, cfmMpid);
    }

    /**
     * Get the Column entity which column name is "cfm_remote_mpid" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "cfm_remote_mpid"
     * @throws Throwable
     */
    public Column getCfmRemoteMpidColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cfm_remote_mpid",
                                                             "getCfmRemoteMpidColumn",
                                                             "4.0.0", "5.2.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "cfm_remote_mpid" to the Row
     * entity of attributes.
     * @param name the column data which column name is "cfm_remote_mpid"
     * @throws Throwable
     */
    public void setCfmRemoteMpid(Set<Long> cfmRemoteMpid) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cfm_remote_mpid",
                                                             "setCfmRemoteMpid",
                                                             "4.0.0", "5.2.0");
        super.setDataHandler(columndesc, cfmRemoteMpid);
    }

    /**
     * Get the Column entity which column name is "cfm_remote_mpids" from the
     * Row entity of attributes.
     * @return the Column entity which column name is "cfm_remote_mpids"
     * @throws Throwable
     */
    public Column getCfmRemoteMpidsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cfm_remote_mpids",
                                                             "getCfmRemoteMpidsColumn",
                                                             "6.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "cfm_remote_mpids" to the Row
     * entity of attributes.
     * @param name the column data which column name is "cfm_remote_mpids"
     * @throws Throwable
     */
    public void setCfmRemoteMpids(Set<Long> cfmRemoteMpids) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cfm_remote_mpids",
                                                             "setCfmRemoteMpids",
                                                             "6.0.0");
        super.setDataHandler(columndesc, cfmRemoteMpids);
    }

    /**
     * Get the Column entity which column name is "cfm_flap_count" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "cfm_flap_count"
     * @throws Throwable
     */
    public Column getCfmFlapCountColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cfm_flap_count",
                                                             "getCfmFlapCountColumn",
                                                             "7.3.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "cfm_flap_count" to the Row
     * entity of attributes.
     * @param name the column data which column name is "cfm_flap_count"
     * @throws Throwable
     */
    public void setCfmFlapCount(Set<Long> cfmFlapCount) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("cfm_flap_count",
                                                             "setCfmFlapCount",
                                                             "7.3.0");
        super.setDataHandler(columndesc, cfmFlapCount);
    }

    /**
     * Get the Column entity which column name is "cfm_fault" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "cfm_fault"
     * @throws Throwable
     */
    public Column getCfmFaultColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cfm_fault",
                                                             "getCfmFaultColumn",
                                                             "4.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "cfm_fault" to the Row entity of
     * attributes.
     * @param name the column data which column name is "cfm_fault"
     * @throws Throwable
     */
    public void setCfmFault(Set<Boolean> cfmFault) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("cfm_fault",
                                                             "setCfmFault",
                                                             "4.0.0");
        super.setDataHandler(columndesc, cfmFault);
    }

    /**
     * Get the Column entity which column name is "cfm_fault_status" from the
     * Row entity of attributes.
     * @return the Column entity which column name is "cfm_fault_status"
     * @throws Throwable
     */
    public Column getCfmFaultStatusColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cfm_fault_status",
                                                             "getCfmFaultStatusColumn",
                                                             "6.6.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "cfm_fault_status" to the Row
     * entity of attributes.
     * @param name the column data which column name is "cfm_fault_status"
     * @throws Throwable
     */
    public void setCfmFaultStatus(Set<String> cfmFaultStatus) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cfm_fault_status",
                                                             "setCfmFaultStatus",
                                                             "6.6.0");
        super.setDataHandler(columndesc, cfmFaultStatus);
    }

    /**
     * Get the Column entity which column name is "cfm_remote_opstate" from the
     * Row entity of attributes.
     * @return the Column entity which column name is "cfm_remote_opstate"
     * @throws Throwable
     */
    public Column getCfmRemoteOpStateColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cfm_remote_opstate",
                                                             "getCfmRemoteOpStateColumn",
                                                             "6.10.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "cfm_remote_opstate" to the Row
     * entity of attributes.
     * @param name the column data which column name is "cfm_remote_opstate"
     * @throws Throwable
     */
    public void setCfmRemoteOpState(Set<String> cfmRemoteOpState)
            throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cfm_remote_opstate",
                                                             "setCfmRemoteOpState",
                                                             "6.10.0");
        super.setDataHandler(columndesc, cfmRemoteOpState);
    }

    /**
     * Get the Column entity which column name is "cfm_health" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "cfm_health"
     * @throws Throwable
     */
    public Column getCfmHealthColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cfm_health",
                                                             "getCfmHealthColumn",
                                                             "6.9.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "cfm_health" to the Row entity
     * of attributes.
     * @param name the column data which column name is "cfm_health"
     * @throws Throwable
     */
    public void setCfmHealth(Set<Long> cfmHealth) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("cfmHealth",
                                                             "setCfmHealth",
                                                             "6.9.0");
        super.setDataHandler(columndesc, cfmHealth);
    }

    /**
     * Get the Column entity which column name is "lacp_current" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "lacp_current"
     * @throws Throwable
     */
    public Column getLacpCurrentColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "lacp_current",
                                                             "getLacpCurrentColumn",
                                                             "3.3.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "lacp_current" to the Row entity
     * of attributes.
     * @param name the column data which column name is "lacp_current"
     * @throws Throwable
     */
    public void setLacpCurrent(Set<Boolean> lacpCurrent) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("lacp_current",
                                                             "setLacpCurrent",
                                                             "3.3.0");
        super.setDataHandler(columndesc, lacpCurrent);
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
     * @param name the column data which column name is "other_config"
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
     * Get the Column entity which column name is "statistics" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "statistics"
     * @throws Throwable
     */
    public Column getStatisticsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "statistics",
                                                             "getStatisticsColumn",
                                                             "1.0.0");
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
                                                             "1.0.0");
        super.setDataHandler(columndesc, statistics);
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
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "status" to the Row entity of
     * attributes.
     * @param name the column data which column name is "status"
     * @throws Throwable
     */
    public void setStatus(Map<String, String> status) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("status",
                                                             "setStatus",
                                                             "1.0.0");
        super.setDataHandler(columndesc, status);
    }

    /**
     * Get the Column entity which column name is "admin_state" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "admin_state"
     * @throws Throwable
     */
    public Column getAdminStateColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "admin_state",
                                                             "getAdminStateColumn",
                                                             "1.0.6");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "admin_state" to the Row entity
     * of attributes.
     * @param name the column data which column name is "admin_state"
     * @throws Throwable
     */
    public void setAdminState(Set<String> adminState) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("admin_state",
                                                             "setAdminState",
                                                             "1.0.6");
        super.setDataHandler(columndesc, adminState);
    }

    /**
     * Get the Column entity which column name is "link_state" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "link_state"
     * @throws Throwable
     */
    public Column getLinkStateColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "link_state",
                                                             "getLinkStateColumn",
                                                             "1.0.6");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "link_state" to the Row entity
     * of attributes.
     * @param name the column data which column name is "link_state"
     * @throws Throwable
     */
    public void setLinkState(Map<String, String> linkState) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("link_state",
                                                             "setLinkState",
                                                             "1.0.6");
        super.setDataHandler(columndesc, linkState);
    }

    /**
     * Get the Column entity which column name is "link_resets" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "link_resets"
     * @throws Throwable
     */
    public Column getLinkResetsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "link_resets",
                                                             "getLinkResetsColumn",
                                                             "6.2.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "link_resets" to the Row entity
     * of attributes.
     * @param name the column data which column name is "link_resets"
     * @throws Throwable
     */
    public void setLinkResets(Set<String> linkResets) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("link_resets",
                                                             "setLinkResets",
                                                             "6.2.0");
        super.setDataHandler(columndesc, linkResets);
    }

    /**
     * Get the Column entity which column name is "link_speed" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "link_speed"
     * @throws Throwable
     */
    public Column getLinkSpeedColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "link_speed",
                                                             "getLinkSpeedColumn",
                                                             "1.0.6");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "link_speed" to the Row entity
     * of attributes.
     * @param name the column data which column name is "link_speed"
     * @throws Throwable
     */
    public void setLinkSpeed(Set<Long> linkSpeed) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("link_speed",
                                                             "setLinkSpeed",
                                                             "1.0.6");
        super.setDataHandler(columndesc, linkSpeed);
    }

    /**
     * Get the Column entity which column name is "duplex" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "duplex"
     * @throws Throwable
     */
    public Column getDuplexColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("duplex",
                                                             "getDuplexColumn",
                                                             "1.0.6");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "duplex" to the Row entity of
     * attributes.
     * @param name the column data which column name is "duplex"
     * @throws Throwable
     */
    public void setDuplex(Set<Long> duplex) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("duplex",
                                                             "setDuplex",
                                                             "1.0.6");
        super.setDataHandler(columndesc, duplex);
    }

    /**
     * Get the Column entity which column name is "mtu" from the Row entity of
     * attributes.
     * @return the Column entity which column name is "mtu"
     * @throws Throwable
     */
    public Column getMtuColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("mtu",
                                                             "getMtuColumn",
                                                             "1.0.6");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "mtu" to the Row entity of
     * attributes.
     * @param name the column data which column name is "mtu"
     * @throws Throwable
     */
    public void setMtu(Set<Long> mtu) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("mtu", "setMtu",
                                                             "1.0.6");
        super.setDataHandler(columndesc, mtu);
    }

    /**
     * Get the Column entity which column name is "error" from the Row entity of
     * attributes.
     * @return the Column entity which column name is "error"
     * @throws Throwable
     */
    public Column getErrorColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("error",
                                                             "getErrorColumn",
                                                             "7.7.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "error" to the Row entity of
     * attributes.
     * @param name the column data which column name is "error"
     * @throws Throwable
     */
    public void setError(Set<String> error) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("error",
                                                             "setError",
                                                             "7.7.0");
        super.setDataHandler(columndesc, error);
    }

}
