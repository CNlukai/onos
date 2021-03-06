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
import org.onosproject.ovsdb.lib.notation.Mutation;
import org.onosproject.ovsdb.lib.schema.TableSchema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * mutate operation.Refer to RFC 7047 Section 5.2.
 */
public class Mutate implements Operation {

    @JsonIgnore
    private final TableSchema tableSchema;
    private final String op;
    private final List<Condition> where;
    private final List<Mutation> mutations;

    /**
     * Constructs a Mutate object.
     * @param schema TableSchema entity
     * @param where the List of Condition entity
     * @param mutations the List of Mutation entity
     */
    public Mutate(TableSchema schema, List<Condition> where,
                  List<Mutation> mutations) {
        checkNotNull(schema, "TableSchema is not null");
        checkNotNull(mutations, "mutations is not null");
        checkNotNull(where, "where is not null");
        this.tableSchema = schema;
        this.op = Operations.MUTATE.getName();
        this.where = where;
        this.mutations = mutations;
    }

    /**
     * Returns the mutations member of mutate operation.
     * @return the mutations member of mutate operation
     */
    public List<Mutation> getMutations() {
        return mutations;
    }

    /**
     * Returns the where member of mutate operation.
     * @return the where member of mutate operation
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
