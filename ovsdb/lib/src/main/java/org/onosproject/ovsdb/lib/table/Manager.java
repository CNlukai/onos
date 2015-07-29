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
 * This class provides operations of Manager Table.
 */
public class Manager extends AbstractOvsdbTableService {

    /**
     * Constructs a Manager object. Generate Manager Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public Manager(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "Manager", "1.0.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("Manager"));
        }
    }

    /**
     * Get the Column entity which column name is "target" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "target"
     * @throws Throwable
     */
    public Column getTargetColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("target",
                                                             "getTargetColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "target" to the Row entity of
     * attributes.
     * @param name the column data which column name is "target"
     * @throws Throwable
     */
    public void setTarget(Set<String> target) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("target",
                                                             "setTarget",
                                                             "1.0.0");
        super.setDataHandler(columndesc, target);
    }

    /**
     * Get the Column entity which column name is "is_connected" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "is_connected"
     * @throws Throwable
     */
    public Column getIsConnectedColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "is_connected",
                                                             "getIsConnectedColumn",
                                                             "1.1.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "is_connected" to the Row entity
     * of attributes.
     * @param name the column data which column name is "is_connected"
     * @throws Throwable
     */
    public void setIsConnected(Boolean isConnected) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("is_connected",
                                                             "setIsConnected",
                                                             "1.1.0");
        super.setDataHandler(columndesc, isConnected);
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
                                                             "6.8.0");
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
                                                             "6.8.0");
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
     * Get the Column entity which column name is "max_backoff" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "max_backoff"
     * @throws Throwable
     */
    public Column getMaxBackoffColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "max_backoff",
                                                             "getMaxBackoffColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "max_backoff" to the Row entity
     * of attributes.
     * @param name the column data which column name is "max_backoff"
     * @throws Throwable
     */
    public void setMaxBackoff(Set<Long> maxBackoff) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("max_backoff",
                                                             "setMaxBackoff",
                                                             "1.0.0");
        super.setDataHandler(columndesc, maxBackoff);
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
                                                             "1.1.0");
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
                                                             "1.1.0");
        super.setDataHandler(columndesc, status);
    }

    /**
     * Get the Column entity which column name is "inactivity_probe" from the
     * Row entity of attributes.
     * @return the Column entity which column name is "inactivity_probe"
     * @throws Throwable
     */
    public Column getInactivityProbeColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "inactivity_probe",
                                                             "getInactivityProbeColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "inactivity_probe" to the Row
     * entity of attributes.
     * @param name the column data which column name is "inactivity_probe"
     * @throws Throwable
     */
    public void setInactivityProbe(Set<Long> inactivityProbe) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "inactivity_probe",
                                                             "setInactivityProbe",
                                                             "1.0.0");
        super.setDataHandler(columndesc, inactivityProbe);
    }

    /**
     * Get the Column entity which column name is "connection_mode" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "connection_mode"
     * @throws Throwable
     */
    public Column getConnectionModeColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "connection_mode",
                                                             "getConnectionModeColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "connection_mode" to the Row
     * entity of attributes.
     * @param name the column data which column name is "connection_mode"
     * @throws Throwable
     */
    public void setConnectionMode(Set<String> connectionMode) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "connection_mode",
                                                             "setConnectionMode",
                                                             "1.0.0");
        super.setDataHandler(columndesc, connectionMode);
    }
}
