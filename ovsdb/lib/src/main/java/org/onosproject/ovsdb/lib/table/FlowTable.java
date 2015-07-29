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
 * This class provides operations of FlowTable Table.
 */
public class FlowTable extends AbstractOvsdbTableService {

    /**
     * Constructs a FlowTable object. Generate FlowTable Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public FlowTable(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "Flow_Table", "6.5.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("Flow_Table"));
        }
    }

    /**
     * Get the Column entity which column name is "flow_limit" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "flow_limit"
     * @throws Throwable
     */
    public Column getFlowLimitColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "flow_limit",
                                                             "getFlowLimitColumn",
                                                             "6.5.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "flow_limit" to the Row entity
     * of attributes.
     * @param name the column data which column name is "flow_limit"
     * @throws Throwable
     */
    public void setFlowLimit(Set<Long> flowLimit) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("flow_limit",
                                                             "setFlowLimit",
                                                             "6.5.0");
        super.setDataHandler(columndesc, flowLimit);
    }

    /**
     * Get the Column entity which column name is "overflow_policy" from the Row
     * entity of attributes.
     * @return the Column entity which column name is "overflow_policy"
     * @throws Throwable
     */
    public Column getOverflowPolicyColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "overflow_policy",
                                                             "getOverflowPolicyColumn",
                                                             "6.5.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "overflow_policy" to the Row
     * entity of attributes.
     * @param name the column data which column name is "overflow_policy"
     * @throws Throwable
     */
    public void setOverflowPolicy(Set<String> overflowPolicy) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "overflow_policy",
                                                             "setOverflowPolicy",
                                                             "6.5.0");
        super.setDataHandler(columndesc, overflowPolicy);
    }

    /**
     * Get the Column entity which column name is "groups" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "groups"
     * @throws Throwable
     */
    public Column getGroupsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("groups",
                                                             "getGroupsColumn",
                                                             "6.5.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "groups" to the Row entity of
     * attributes.
     * @param name the column data which column name is "groups"
     * @throws Throwable
     */
    public void setGroups(Set<String> groups) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("groups",
                                                             "setGroups",
                                                             "6.5.0");
        super.setDataHandler(columndesc, groups);
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
                                                             "6.5.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "name" to the Row entity of
     * attributes.
     * @param name the column data which column name is "name"
     * @throws Throwable
     */
    public void setName(Set<String> name) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("name", "setName",
                                                             "6.5.0");
        super.setDataHandler(columndesc, name);
    }

    /**
     * Get the Column entity which column name is "prefixes" from the Row entity
     * of attributes.
     * @return the Column entity which column name is "prefixes"
     * @throws Throwable
     */
    public Column getPrefixesColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "prefixes",
                                                             "getPrefixesColumn",
                                                             "7.4.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "prefixes" to the Row entity of
     * attributes.
     * @param name the column data which column name is "prefixes"
     * @throws Throwable
     */
    public void setPrefixes(Set<String> prefixes) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("prefixes",
                                                             "setPrefixes",
                                                             "7.4.0");
        super.setDataHandler(columndesc, prefixes);
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
                                                             "7.5.0");
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
                                                             "7.5.0");
        super.setDataHandler(columndesc, externalIds);
    }

}
