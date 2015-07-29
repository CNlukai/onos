package org.onosproject.ovsdb.lib.table;

import java.util.Map;
import java.util.Set;

import org.onosproject.ovsdb.lib.notation.Column;
import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;
import org.onosproject.ovsdb.lib.tableservice.AbstractOvsdbTableService;
import org.onosproject.ovsdb.lib.tableservice.ColumnDescription;

/**
 * This class provides operations of Queue Table.
 */
public class Queue extends AbstractOvsdbTableService {
    /**
     * Constructs a Queue object. Generate Queue Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public Queue(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "Queue", "1.0.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("Queue"));
        }
    }

    /**
     * Get the Column entity which column name is "dscp" from the Row entity of
     * attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getDscpColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("dscp",
                                                             "getDscpColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "dscp" to the Row entity of
     * attributes.
     * @param dscp the column data which column name is "dscp"
     * @throws Throwable
     */
    public void setDscp(Set<Long> dscp) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("dscp", "setDscp",
                                                             "1.0.0");
        super.setDataHandler(columndesc, dscp);
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
