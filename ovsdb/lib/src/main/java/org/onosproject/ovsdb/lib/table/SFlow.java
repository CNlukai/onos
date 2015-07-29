package org.onosproject.ovsdb.lib.table;

import java.util.Map;
import java.util.Set;

import org.onosproject.ovsdb.lib.notation.Column;
import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;
import org.onosproject.ovsdb.lib.tableservice.AbstractOvsdbTableService;
import org.onosproject.ovsdb.lib.tableservice.ColumnDescription;

/**
 * This class provides operations of SFlow Table.
 */
public class SFlow extends AbstractOvsdbTableService {
    /**
     * Constructs a SFlow object. Generate SFlow Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public SFlow(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "sFlow", "1.0.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("sFlow"));
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
     * Get the Column entity which column name is "agent" from the Row entity of
     * attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getAgentColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("agent",
                                                             "getAgentColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "agent" to the Row entity of
     * attributes.
     * @param agent the column data which column name is "agent"
     * @throws Throwable
     */
    public void setAgent(Set<String> agent) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("agent",
                                                             "setAgent",
                                                             "1.0.0");
        super.setDataHandler(columndesc, agent);
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
     * Get the Column entity which column name is "header" from the Row entity
     * of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getHeaderColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("header",
                                                             "getHeaderColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "header" to the Row entity of
     * attributes.
     * @param header the column data which column name is "header"
     * @throws Throwable
     */
    public void setHeader(Set<Long> header) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("header",
                                                             "setHeader",
                                                             "1.0.0");
        super.setDataHandler(columndesc, header);
    }

    /**
     * Get the Column entity which column name is "polling" from the Row entity
     * of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getPollingColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "polling",
                                                             "getPollingColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "polling" to the Row entity of
     * attributes.
     * @param polling the column data which column name is "polling"
     * @throws Throwable
     */
    public void setPolling(Set<Long> polling) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("polling",
                                                             "setPolling",
                                                             "1.0.0");
        super.setDataHandler(columndesc, polling);
    }

    /**
     * Get the Column entity which column name is "sampling" from the Row entity
     * of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getSamplingColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "sampling",
                                                             "getSamplingColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "sampling" to the Row entity of
     * attributes.
     * @param sampling the column data which column name is "sampling"
     * @throws Throwable
     */
    public void setSampling(Set<Long> sampling) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("sampling",
                                                             "setSampling",
                                                             "1.0.0");
        super.setDataHandler(columndesc, sampling);
    }
}
