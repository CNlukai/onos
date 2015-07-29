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
package org.onosproject.ovsdb.lib.operations;

import org.onosproject.ovsdb.lib.schema.TableSchema;

/**
 * Operation interface.
 */
public interface Operation {

    /**
     * Returns the op member of update operation.
     * @return the op member of update operation
     */
    String getOp();

    /**
     * Returns TableSchema entity.
     * @return TableSchema entity
     */
    TableSchema getTableSchema();

    /**
     * Operations must be "insert", "select", "update", "mutate", "delete",
     * "commit", "abort", "comment", "assert". Refer to RFC 7047 Section 5.2.
     */
    public enum Operations {
        INSERT("insert"), SELECT("select"), UPDATE("update"), MUTATE("mutate"),
        DELETE("delete"), COMMIT("commit"), ABORT("abort"), COMMENT("comment"),
        ASSERT("assert");

        private Operations(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }
    }
}
