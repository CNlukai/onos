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
package org.onosproject.ovsdb.lib.jsonrpc;

import java.util.List;

import org.onosproject.ovsdb.lib.operations.Operation;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * The following interface describe the RPC 7047 methods that are supported.
 */
public interface OvsdbRPC {

    /**
     * This operation retrieves a <database-schema> that describes hosted
     * database <db-name>.
     * @param dbnames database name
     * @return the return jsonnode
     */
    ListenableFuture<JsonNode> getSchema(List<String> dbnames);

    /**
     * The "echo" method can be used by both clients and servers to verify the
     * liveness of a database connection.
     * @return return info
     */
    ListenableFuture<List<String>> echo();

    /**
     * The "monitor" request enables a client to replicate tables or subsets of
     * tables within an OVSDB database by requesting notifications of changes to
     * those tables and by receiving the complete initial state of a table or a
     * subset of a table.
     * @param dbSchema databse schema
     * @return josnnode
     */
    ListenableFuture<JsonNode> monitor(DatabaseSchema dbSchema, String monitorId);

    /**
     * This operation retrieves an array whose elements are the names of the
     * databases that can be accessed over this management protocol connection.
     * @return database names
     */
    ListenableFuture<List<String>> listDbs();

    /**
     * This RPC method causes the database server to execute a series of
     * operations in the specified order on a given database.
     * @param dbSchema database schema
     * @param operations the operations to execute
     * @return result the transact result
     */
    ListenableFuture<List<JsonNode>> transact(DatabaseSchema dbSchema,
                                              List<Operation> operations);

}
