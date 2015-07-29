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

import org.onosproject.ovsdb.lib.utils.VersionUtil;

/**
 * Table description.
 */
public class TableDescription {

    // The table name
    private final String name;
    // The database name
    private final String database = "Open_vSwitch";
    // The initial version
    private final String fromVersion;
    // The end of the version
    private final String untilVersion;

    /**
     * Constructs a MonitorRequest object.
     * @param name column name
     */
    public TableDescription(String name) {
        this.name = name;
        this.fromVersion = VersionUtil.DEFAULT_VERSION_STRING;
        this.untilVersion = VersionUtil.DEFAULT_VERSION_STRING;
    }

    /**
     * Constructs a MonitorRequest object.
     * @param name column name
     * @param fromVersion the initial version
     */
    public TableDescription(String name, String fromVersion) {
        this.name = name;
        this.fromVersion = fromVersion;
        this.untilVersion = VersionUtil.DEFAULT_VERSION_STRING;
    }

    /**
     * Constructs a MonitorRequest object.
     * @param name column name
     * @param fromVersion the initial version
     * @param untilVersion the end of the version
     */
    public TableDescription(String name, String fromVersion, String untilVersion) {
        this.name = name;
        this.fromVersion = fromVersion;
        this.untilVersion = untilVersion;
    }

    /**
     * Returns the column name.
     * @return the column name
     */
    public String name() {
        return name;
    }

    /**
     * Returns the database name.
     * @return the database name
     */
    public String database() {
        return database;
    }

    /**
     * Returns the initial version.
     * @return the initial version
     */
    public String fromVersion() {
        return fromVersion;
    }

    /**
     * Returns the end of the version.
     * @return the end of the version
     */
    public String untilVersion() {
        return untilVersion;
    }
}
