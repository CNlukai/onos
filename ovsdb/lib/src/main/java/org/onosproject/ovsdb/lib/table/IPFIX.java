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
 * This class provides operations of IPFIX Table.
 */
public class IPFIX extends AbstractOvsdbTableService {

    /**
     * Constructs a IPFIX object. Generate IPFIX Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public IPFIX(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "IPFIX", "7.1.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("IPFIX"));
        }
    }

    /**
     * Get the Column entity which column name is "targets" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "targets"
     * @throws Throwable
     */
    public Column getTargetsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "targets",
                                                             "getTargetsColumn",
                                                             "7.1.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "targets" to the Row entity of
     * attributes.
     * @param name the column data which column name is "targets"
     * @throws Throwable
     */
    public void setTargets(Set<String> targets) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("targets",
                                                             "setTargets",
                                                             "7.1.0");
        super.setDataHandler(columndesc, targets);
    }

    /**
     * Get the Column entity which column name is "sampling" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "sampling"
     * @throws Throwable
     */
    public Column getSamplingColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "sampling",
                                                             "getSamplingColumn",
                                                             "7.1.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "sampling" to the Row entity of
     * attributes.
     * @param name the column data which column name is "sampling"
     * @throws Throwable
     */
    public void setSampling(Set<Long> sampling) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("sampling",
                                                             "setSampling",
                                                             "7.1.0");
        super.setDataHandler(columndesc, sampling);
    }

    /**
     * Get the Column entity which column name is "obs_domain_id" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "obs_domain_id"
     * @throws Throwable
     */
    public Column getObsDomainIdColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "obs_domain_id",
                                                             "getObsDomainIdColumn",
                                                             "7.1.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "obs_domain_id" to the Row
     * entity of attributes.
     * @param name the column data which column name is "obs_domain_id"
     * @throws Throwable
     */
    public void setObsDomainId(Set<Long> obsdomainid) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("obs_domain_id",
                                                             "setObsDomainId",
                                                             "7.1.0");
        super.setDataHandler(columndesc, obsdomainid);
    }

    /**
     * Get the Column entity which column name is "obs_point_id" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "obs_point_id"
     * @throws Throwable
     */
    public Column getObsPointIdColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "obs_point_id",
                                                             "getObsPointIdColumn",
                                                             "7.1.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "obs_point_id" to the Row entity
     * of attributes.
     * @param name the column data which column name is "obs_point_id"
     * @throws Throwable
     */
    public void setObsPointId(Set<Long> obsPointId) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("obs_point_id",
                                                             "setObsPointId",
                                                             "7.1.0");
        super.setDataHandler(columndesc, obsPointId);
    }

    /**
     * Get the Column entity which column name is "cache_active_timeout" from
     * the Row entity of attributes.
     * @return the Column entity which column name is "cache_active_timeout"
     * @throws Throwable
     */
    public Column getCacheActiveTimeoutColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cache_active_timeout",
                                                             "getCacheActiveTimeoutColumn",
                                                             "7.3.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "cache_active_timeout" to the
     * Row entity of attributes.
     * @param name the column data which column name is "cache_active_timeout"
     * @throws Throwable
     */
    public void setCacheActiveTimeout(Set<Long> cacheActiveTimeout)
            throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cache_active_timeout",
                                                             "setCacheActiveTimeout",
                                                             "7.3.0");
        super.setDataHandler(columndesc, cacheActiveTimeout);
    }

    /**
     * Get the Column entity which column name is "cache_max_flows" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "cache_max_flows"
     * @throws Throwable
     */
    public Column getCacheMaxFlowsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cache_max_flows",
                                                             "getCacheMaxFlowsColumn",
                                                             "7.3.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "cache_max_flows" to the Row
     * entity of attributes.
     * @param name the column data which column name is "cache_max_flows"
     * @throws Throwable
     */
    public void setCacheMaxFlows(Set<Long> cacheMaxFlows) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "cache_max_flows",
                                                             "setCacheMaxFlows",
                                                             "7.3.0");
        super.setDataHandler(columndesc, cacheMaxFlows);
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
                                                             "7.1.0");
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
                                                             "7.1.0");
        super.setDataHandler(columndesc, externalIds);
    }
}
