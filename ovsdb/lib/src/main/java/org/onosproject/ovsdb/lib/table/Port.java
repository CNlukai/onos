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
 * This class provides operations of Port Table.
 */
public class Port extends AbstractOvsdbTableService {
    /**
     * Constructs a Port object. Generate Port Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public Port(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "Port", "1.0.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("Port"));
        }
    }

    /**
     * Get the Column entity which column name is "name" from the Row entity of
     * attributes.
     * @return the Column entity
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
     * Get the Column entity which column name is "name" from the Row entity of
     * attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public String getName() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("name", "getName",
                                                             "1.0.0");
        return (String) super.getDataHandler(columndesc);
    }

    /**
     * Get the Column entity which column name is "interfaces" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getInterfacesColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "interfaces",
                                                             "getInterfacesColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "interfaces" to the Row entity
     * of attributes.
     * @param interfaces the column data which column name is "interfaces"
     * @throws Throwable
     */
    public void setInterfaces(Set<UUID> interfaces) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("interfaces",
                                                             "setInterfaces",
                                                             "1.0.0");
        super.setDataHandler(columndesc, interfaces);
    }

    /**
     * Get the Column entity which column name is "trunks" from the Row entity
     * of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getTrunksColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("trunks",
                                                             "getTrunksColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "trunks" to the Row entity of
     * attributes.
     * @param trunks the column data which column name is "trunks"
     * @throws Throwable
     */
    public void setTrunks(Set<Long> trunks) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("trunks",
                                                             "setTrunks",
                                                             "1.0.0");
        super.setDataHandler(columndesc, trunks);
    }

    /**
     * Get the Column entity which column name is "tag" from the Row entity of
     * attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getTagColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("tag",
                                                             "getTagColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "tag" to the Row entity of
     * attributes.
     * @param tag the column data which column name is "tag"
     * @throws Throwable
     */
    public void setTag(Set<Long> tag) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("tag", "setTag",
                                                             "1.0.0");
        super.setDataHandler(columndesc, tag);
    }

    /**
     * Get the Column entity which column name is "vlan_mode" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getVlanModeColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "vlan_mode",
                                                             "getVlanModeColumn",
                                                             "6.1.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "vlan_mode" to the Row entity of
     * attributes.
     * @param vlanMode the column data which column name is "vlan_mode"
     * @throws Throwable
     */
    public void setVlanMode(Set<String> vlanMode) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("vlan_mode",
                                                             "setVlanMode",
                                                             "6.1.0");
        super.setDataHandler(columndesc, vlanMode);
    }

    /**
     * Get the Column entity which column name is "qos" from the Row entity of
     * attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getQosColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("qos",
                                                             "getQosColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "qos" to the Row entity of
     * attributes.
     * @param qos the column data which column name is "qos"
     * @throws Throwable
     */
    public void setQos(Set<UUID> qos) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("qos", "setQos",
                                                             "1.0.0");
        super.setDataHandler(columndesc, qos);
    }

    /**
     * Get the Column entity which column name is "mac" from the Row entity of
     * attributes.
     * @return the Column entity
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
     * @param mac the column data which column name is "mac"
     * @throws Throwable
     */
    public void setMac(Set<String> mac) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("mac", "setMac",
                                                             "1.0.0");
        super.setDataHandler(columndesc, mac);
    }

    /**
     * Get the Column entity which column name is "bond_type" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getBondTypeColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "bond_type",
                                                             "getBondTypeColumn",
                                                             "1.0.2", "1.0.3");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "bond_type" to the Row entity of
     * attributes.
     * @param bondtype the column data which column name is "bond_type"
     * @throws Throwable
     */
    public void setBondType(Set<String> bondtype) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("bond_type",
                                                             "setBondType",
                                                             "1.0.2", "1.0.3");
        super.setDataHandler(columndesc, bondtype);
    }

    /**
     * Get the Column entity which column name is "bond_mode" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getBondModeColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "bond_mode",
                                                             "getBondModeColumn",
                                                             "1.0.4");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "bond_mode" to the Row entity of
     * attributes.
     * @param bondmode the column data which column name is "bond_mode"
     * @throws Throwable
     */
    public void setBondMode(Set<String> bondmode) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("bond_mode",
                                                             "setBondMode",
                                                             "1.0.4");
        super.setDataHandler(columndesc, bondmode);
    }

    /**
     * Get the Column entity which column name is "lacp" from the Row entity of
     * attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getLacpColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("lacp",
                                                             "getLacpColumn",
                                                             "1.3.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "lacp" to the Row entity of
     * attributes.
     * @param lacp the column data which column name is "lacp"
     * @throws Throwable
     */
    public void setLacp(Set<String> lacp) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("lacp", "setLacp",
                                                             "1.3.0");
        super.setDataHandler(columndesc, lacp);
    }

    /**
     * Get the Column entity which column name is "bond_updelay" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getBondUpDelayColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "bond_updelay",
                                                             "getBondUpDelayColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "bond_updelay" to the Row entity
     * of attributes.
     * @param bondUpDelay the column data which column name is "bond_updelay"
     * @throws Throwable
     */
    public void setBondUpDelay(Set<Long> bondUpDelay) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("bond_updelay",
                                                             "setBondUpDelay",
                                                             "1.0.0");
        super.setDataHandler(columndesc, bondUpDelay);
    }

    /**
     * Get the Column entity which column name is "bond_downdelay" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getBondDownDelayColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "bond_downdelay",
                                                             "getBondDownDelayColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "bond_downdelay" to the Row
     * entity of attributes.
     * @param bondDownDelay the column data which column name is
     *            "bond_downdelay"
     * @throws Throwable
     */
    public void setBondDownDelay(Set<Long> bondDownDelay) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "bond_downdelay",
                                                             "setBondDownDelay",
                                                             "1.0.0");
        super.setDataHandler(columndesc, bondDownDelay);
    }

    /**
     * Get the Column entity which column name is "bond_fake_iface" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getBondFakeInterfaceColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "bond_fake_iface",
                                                             "getBondFakeInterfaceColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "fake_bridge" to the Row entity
     * of attributes.
     * @param bondFakeInterface the column data which column name is
     *            "fake_bridge"
     * @throws Throwable
     */
    public void setBondFakeInterface(Set<Boolean> bondFakeInterface)
            throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "fake_bridge",
                                                             "setBondFakeInterface",
                                                             "1.0.0");
        super.setDataHandler(columndesc, bondFakeInterface);
    }

    /**
     * Get the Column entity which column name is "fake_bridge" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getFakeBridgeColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "fake_bridge",
                                                             "getFakeBridgeColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "fake_bridge" to the Row entity
     * of attributes.
     * @param fakeBridge the column data which column name is "fake_bridge"
     * @throws Throwable
     */
    public void setFakeBridge(Set<Boolean> fakeBridge) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("fake_bridge",
                                                             "setFakeBridge",
                                                             "1.0.0");
        super.setDataHandler(columndesc, fakeBridge);
    }

    /**
     * Get the Column entity which column name is "status" from the Row entity
     * of attributes.
     * @return the Column entity
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
     * @param status the column data which column name is "status"
     * @throws Throwable
     */
    public void setStatus(Map<String, String> status) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("status",
                                                             "setStatus",
                                                             "6.2.0");
        super.setDataHandler(columndesc, status);
    }

    /**
     * Get the Column entity which column name is "statistics" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getStatisticsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "statistics",
                                                             "getStatisticsColumn",
                                                             "6.3.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "statistics" to the Row entity
     * of attributes.
     * @param statistics the column data which column name is "statistics"
     * @throws Throwable
     */
    public void setStatistics(Map<String, Long> statistics) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("statistics",
                                                             "setStatistics",
                                                             "6.3.0");
        super.setDataHandler(columndesc, statistics);
    }

    /**
     * Get the Column entity which column name is "other_config" from the Row
     * entity of attributes.
     * @return the Column entity
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
     * @param otherConfig the column data which column name is "other_config"
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
     * @return the Column entity
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
     * @param externalIds the column data which column name is "external_ids"
     * @throws Throwable
     */
    public void setExternalIds(Map<String, String> externalIds)
            throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("external_ids",
                                                             "setExternalIds",
                                                             "1.0.0");
        super.setDataHandler(columndesc, externalIds);
    }

}
