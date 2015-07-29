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

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.onosproject.ovsdb.lib.notation.Condition;
import org.onosproject.ovsdb.lib.schema.TableSchema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * delete operation.Refer to RFC 7047 Section 5.2.
 */
public class Delete implements Operation {

    @JsonIgnore
    private final TableSchema tableSchema;
    private final String op;
    private final List<Condition> where;

    /**
     * Constructs a Delete object.
     * @param schema TableSchema entity
     * @param where the List of Condition entity
     */
    public Delete(TableSchema schema, List<Condition> where) {
        checkNotNull(schema, "TableSchema is not null");
        checkNotNull(where, "where is not null");
        this.tableSchema = schema;
        this.op = Operations.DELETE.getName();
        this.where = where;
    }

    /**
     * Returns the where member of delete operation.
     * @return the where member of delete operation
     */
    public List<Condition> getWhere() {
        return where;
    }

    @Override
    public String getOp() {
        return op;
    }

    @Override
    public TableSchema getTableSchema() {
        return tableSchema;
    }

    /**
     * For the use of serialization.
     * @return the table member of update operation
     */
    @JsonProperty
    public String getTable() {
        return (tableSchema == null) ? null : tableSchema.name();
    }
}
