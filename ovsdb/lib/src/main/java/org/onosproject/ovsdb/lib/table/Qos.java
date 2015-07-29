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
 * This class provides operations of Qos Table.
 */
public class Qos extends AbstractOvsdbTableService {
    /**
     * Constructs a Qos object. Generate Qos Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public Qos(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "Qos", "1.0.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("Qos"));
        }
    }

    /**
     * Get the Column entity which column name is "queues" from the Row entity
     * of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getQueuesColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("queues",
                                                             "getQueuesColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "queues" to the Row entity of
     * attributes.
     * @param queues the column data which column name is "queues"
     * @throws Throwable
     */
    public void setQueues(Map<Long, UUID> queues) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("queues",
                                                             "setQueues",
                                                             "1.0.0");
        super.setDataHandler(columndesc, queues);
    }

    /**
     * Get the Column entity which column name is "type" from the Row entity of
     * attributes.
     * @return the Column entity
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
     * @param type the column data which column name is "type"
     * @throws Throwable
     */
    public void setType(Set<String> type) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("type", "setType",
                                                             "1.0.0");
        super.setDataHandler(columndesc, type);
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
