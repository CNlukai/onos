package org.onosproject.ovsdb.lib.table;

import java.util.Map;
import java.util.Set;

import org.onosproject.ovsdb.lib.notation.Column;
import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;
import org.onosproject.ovsdb.lib.tableservice.AbstractOvsdbTableService;
import org.onosproject.ovsdb.lib.tableservice.ColumnDescription;

/**
 * This class provides operations of NetFlow Table.
 */
public class NetFlow extends AbstractOvsdbTableService {
    /**
     * Constructs a NetFlow object. Generate NetFlow Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public NetFlow(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "NetFlow", "1.0.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("NetFlow"));
        }
    }

    /**
     * Get the Column entity which column name is "targets" from the Row entity
     * of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getTargetsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "targets",
                                                             "getTargetsColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "targets" to the Row entity of
     * attributes.
     * @param targets the column data which column name is "targets"
     * @throws Throwable
     */
    public void setTargets(Set<String> targets) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("targets",
                                                             "setTargets",
                                                             "1.0.0");
        super.setDataHandler(columndesc, targets);
    }

    /**
     * Get the Column entity which column name is "active_timeout" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getActiveTimeoutColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "active_timeout",
                                                             "getActiveTimeoutColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "active_timeout" to the Row
     * entity of attributes.
     * @param activeTimeout the column data which column name is
     *            "active_timeout"
     * @throws Throwable
     */
    public void setActiveTimeout(Long activeTimeout) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "active_timeout",
                                                             "setActiveTimeout",
                                                             "1.0.0");
        super.setDataHandler(columndesc, activeTimeout);
    }

    /**
     * Get the Column entity which column name is "engine_type" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getEngineTypeColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "engine_type",
                                                             "getEngineTypeColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "engine_type" to the Row entity
     * of attributes.
     * @param engineType the column data which column name is "engine_type"
     * @throws Throwable
     */
    public void setEngineType(Set<Long> engineType) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("engine_type",
                                                             "setEngineType",
                                                             "1.0.0");
        super.setDataHandler(columndesc, engineType);
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
     * Get the Column entity which column name is "active_timeout" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getActivityTimeoutColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "active_timeout",
                                                             "getActivityTimeoutColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "active_timeout" to the Row
     * entity of attributes.
     * @param activityTimeout the column data which column name is
     *            "active_timeout"
     * @throws Throwable
     */
    public void setActivityTimeout(Set<Long> activityTimeout) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "active_timeout",
                                                             "setActivityTimeout",
                                                             "1.0.0");
        super.setDataHandler(columndesc, activityTimeout);
    }

    /**
     * Get the Column entity which column name is "add_id_to_interface" from the
     * Row entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getAddIdToInterfaceColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "add_id_to_interface",
                                                             "getAddIdToInterfaceColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "add_id_to_interface" to the Row
     * entity of attributes.
     * @param addIdToInterface the column data which column name is
     *            "add_id_to_interface"
     * @throws Throwable
     */
    public void setAddIdToInterface(Boolean addIdToInterface) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "add_id_to_interface",
                                                             "setAddIdToInterface",
                                                             "1.0.0");
        super.setDataHandler(columndesc, addIdToInterface);
    }

    /**
     * Get the Column entity which column name is "engine_id" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getEngineIdColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "engine_id",
                                                             "getEngineIdColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "engine_id" to the Row entity of
     * attributes.
     * @param engineId the column data which column name is "engine_id"
     * @throws Throwable
     */
    public void setEngineId(Set<Long> engineId) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("engine_id",
                                                             "setEngineId",
                                                             "1.0.0");
        super.setDataHandler(columndesc, engineId);
    }

}
