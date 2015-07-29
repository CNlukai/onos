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
package org.onosproject.ovsdb.lib.tableservice;

import org.onosproject.ovsdb.lib.notation.Column;
import org.onosproject.ovsdb.lib.notation.UUID;

/**
 * Representation of conversion between Ovsdb table and Row.
 */
public interface OvsdbTableService {

    /**
     * Get Column from row.
     * @param columndesc Column description
     * @return Column
     * @throws Throwable
     */
    public Column getColumnHandler(ColumnDescription columndesc)
            throws Throwable;

    /**
     * Get Data from row.
     * @param columndesc Column description
     * @return Object column data
     * @throws Throwable
     */
    public Object getDataHandler(ColumnDescription columndesc) throws Throwable;

    /**
     * Set column data of row.
     * @param columndesc Column description
     * @param obj column data
     * @throws Throwable
     */
    public void setDataHandler(ColumnDescription columndesc, Object obj)
            throws Throwable;

    /**
     * Returns the TableSchema from row.
     * @return Object TableSchema
     */
    public Object getTbSchema();

    /**
     * Returns UUID which column name is _uuid.
     * @return UUID
     * @throws Throwable
     */
    public UUID getUuid() throws Throwable;

    /**
     * Returns UUID Column which column name is _uuid.
     * @return UUID Column
     * @throws Throwable
     */
    public Column getUuidColumn() throws Throwable;

    /**
     * Returns UUID which column name is _version.
     * @return UUID
     * @throws Throwable
     */
    public UUID getVersion() throws Throwable;

    /**
     * Returns UUID Column which column name is _version.
     * @return UUID Column
     * @throws Throwable
     */
    public Column getVersionColumn() throws Throwable;
}
