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
 * This class provides operations of Open_vSwitch Table.
 */
public class OpenVSwitch extends AbstractOvsdbTableService {
    /**
     * Constructs a OpenVSwitch object. Generate Open_vSwitch Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public OpenVSwitch(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "Open_vSwitch", "1.0.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("Open_vSwitch"));
        }
    }

    /**
     * Get the Column entity which column name is "bridges" from the Row entity
     * of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getBridgesColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "bridges",
                                                             "getBridgesColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "bridges" to the Row entity of
     * attributes.
     * @param bridges the column data which column name is "bridges"
     * @throws Throwable
     */
    public void setBridges(Set<UUID> bridges) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("bridges",
                                                             "setBridges",
                                                             "1.0.0");
        super.setDataHandler(columndesc, bridges);
    }

    /**
     * Get the Column entity which column name is "managers" from the Row entity
     * of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getManagersColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "managers",
                                                             "getManagersColumn",
                                                             "1.0.0", "2.0.0");
        return (Column) super.getDataHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "managers" to the Row entity of
     * attributes.
     * @param managers the column data which column name is "managers"
     * @throws Throwable
     */
    public void setManagers(Set<UUID> managers) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("managers",
                                                             "setManagers",
                                                             "1.0.0", "2.0.0");
        super.setDataHandler(columndesc, managers);
    }

    /**
     * Get the Column entity which column name is "manager_options" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getManagerOptionsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "manager_options",
                                                             "getManagerOptionsColumn",
                                                             "1.0.0");
        return (Column) super.getDataHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "manager_options" to the Row
     * entity of attributes.
     * @param managerOptions the column data which column name is
     *            "manager_options"
     * @throws Throwable
     */
    public void setManagerOptions(Set<UUID> managerOptions) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "manager_options",
                                                             "setManagerOptions",
                                                             "1.0.0");
        super.setDataHandler(columndesc, managerOptions);
    }

    /**
     * Get the Column entity which column name is "ssl" from the Row entity of
     * attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getSslColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("ssl",
                                                             "getSslColumn",
                                                             "1.0.0");
        return (Column) super.getDataHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "ssl" to the Row entity of
     * attributes.
     * @param ssl the column data which column name is "ssl"
     * @throws Throwable
     */
    public void setSsl(Set<UUID> ssl) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("ssl", "setSsl",
                                                             "1.0.0");
        super.setDataHandler(columndesc, ssl);
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
                                                             "5.1.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "otherConfig" to the Row entity
     * of attributes.
     * @param otherConfig the column data which column name is "otherConfig"
     * @throws Throwable
     */
    public void setOtherConfig(Map<String, String> otherConfig)
            throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("other_config",
                                                             "setOtherConfig",
                                                             "5.1.0");
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

    /**
     * Get the Column entity which column name is "next_cfg" from the Row entity
     * of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getNextConfigColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "next_cfg",
                                                             "getNextConfigColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "next_cfg" to the Row entity of
     * attributes.
     * @param nextConfig the column data which column name is "next_cfg"
     * @throws Throwable
     */
    public void setNextConfig(Long nextConfig) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("next_cfg",
                                                             "setNextConfig",
                                                             "1.0.0");
        super.setDataHandler(columndesc, nextConfig);
    }

    /**
     * Get the Column entity which column name is "cur_cfg" from the Row entity
     * of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getCurrentConfigColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cur_cfg",
                                                             "getCurrentConfigColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "cur_cfg" to the Row entity of
     * attributes.
     * @param currentConfig the column data which column name is "cur_cfg"
     * @throws Throwable
     */
    public void setCurrentConfig(Long currentConfig) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cur_cfg",
                                                             "setCurrentConfig",
                                                             "1.0.0");
        super.setDataHandler(columndesc, currentConfig);
    }

    /**
     * Get the Column entity which column name is "capabilities" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getCapabilitiesColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "capabilities",
                                                             "getCapabilitiesColumn",
                                                             "1.0.0", "6.7.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "capabilities" to the Row entity
     * of attributes.
     * @param capabilities the column data which column name is "capabilities"
     * @throws Throwable
     */
    public void setCapabilities(Map<String, UUID> capabilities)
            throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("capabilities",
                                                             "setCapabilities",
                                                             "1.0.0", "6.7.0");
        super.setDataHandler(columndesc, capabilities);
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
                                                             "1.0.0");
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
                                                             "1.0.0");
        super.setDataHandler(columndesc, statistics);
    }

    /**
     * Get the Column entity which column name is "ovs_version" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getOvsVersionColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "ovs_version",
                                                             "getOvsVersionColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "ovsVersion" to the Row entity
     * of attributes.
     * @param ovsVersion the column data which column name is "ovsVersion"
     * @throws Throwable
     */
    public void setOvsVersion(Set<String> ovsVersion) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("ovs_version",
                                                             "setOvsVersion",
                                                             "1.0.0");
        super.setDataHandler(columndesc, ovsVersion);
    }

    /**
     * Get the Column entity which column name is "db_version" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getDbVersionColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "db_version",
                                                             "getDbVersionColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "db_version" to the Row entity
     * of attributes.
     * @param dbVersion the column data which column name is "db_version"
     * @throws Throwable
     */
    public void setDbVersion(Set<String> dbVersion) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("db_version",
                                                             "setDbVersion",
                                                             "1.0.0");
        super.setDataHandler(columndesc, dbVersion);
    }

    /**
     * Get the Column entity which column name is "system_type" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getSystemTypeColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "system_type",
                                                             "getSystemTypeColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "system_type" to the Row entity
     * of attributes.
     * @param systemType the column data which column name is "system_type"
     * @throws Throwable
     */
    public void setSystemType(Set<String> systemType) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("system_type",
                                                             "setSystemType",
                                                             "1.0.0");
        super.setDataHandler(columndesc, systemType);
    }

    /**
     * Get the Column entity which column name is "system_version" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getSystemVersionColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "system_version",
                                                             "getSystemVersionColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "system_version" to the Row
     * entity of attributes.
     * @param systemVersion the column data which column name is
     *            "system_version"
     * @throws Throwable
     */
    public void setSystemVersion(Set<String> systemVersion) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "system_version",
                                                             "setSystemVersion",
                                                             "1.0.0");
        super.setDataHandler(columndesc, systemVersion);
    }
}
