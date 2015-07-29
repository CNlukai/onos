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
package org.onosproject.ovsdb.lib.utils;

import java.util.List;

import org.onosproject.ovsdb.lib.jsonrpc.JsonRpcRequest;
import org.onosproject.ovsdb.lib.operations.Operation;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * RPC Methods request utility class. Refer to RFC 7047 Section 4.1.
 */
public final class JsonRpcWriterUtil {

    private JsonRpcWriterUtil() {
    }

    /**
     * Returns string of RPC request.
     * @param uuid id of request object
     * @param methodName method of request object
     * @param params params of request object
     * @return String
     * @throws JsonProcessingException
     */
    private static String getRequestStr(String uuid, String methodName,
                                        List params)
            throws JsonProcessingException {
        JsonRpcRequest request;
        if (params != null) {
            request = new JsonRpcRequest(uuid, methodName, params);
        } else {
            request = new JsonRpcRequest(uuid, methodName);
        }
        String str = ObjectMapperUtil.convertToString(request);
        return str;
    }

    /**
     * Returns string of get_schema request.
     * @param uuid id of get_schema request
     * @param dbnames params of get_schema request
     * @return String
     * @throws Throwable
     */
    public static String getSchemaStr(String uuid, List<String> dbnames)
            throws Throwable {
        String methodName = "get_schema";
        return getRequestStr(uuid, methodName, dbnames);
    }

    /**
     * Returns string of echo request.
     * @param uuid id of echo request
     * @return String
     * @throws Throwable
     */
    public static String echoStr(String uuid) throws Throwable {
        String methodName = "echo";
        return getRequestStr(uuid, methodName, null);
    }

    /**
     * Returns string of monitor request.
     * @param uuid id of monitor request
     * @param monotorId <json-value> in params of monitor request
     * @param dbSchema DatabaseSchema entity
     * @return String
     * @throws Throwable
     */
    public static String monitorStr(String uuid, String monotorId,
                                    DatabaseSchema dbSchema) throws Throwable {
        String methodName = "monitor";
        return getRequestStr(uuid, methodName,
                             ParamUtil.getMonitorParams(monotorId, dbSchema));
    }

    /**
     * Returns string of list_dbs request.
     * @param uuid id of list_dbs request
     * @return String
     * @throws Throwable
     */
    public static String listDbsStr(String uuid) throws Throwable {
        String methodName = "list_dbs";
        return getRequestStr(uuid, methodName, null);
    }

    /**
     * Returns string of transact request.
     * @param uuid id of transact request
     * @param dbSchema DatabaseSchema entity
     * @param operations <operation>* in params of transact request
     * @return String
     * @throws Throwable
     */
    public static String transactStr(String uuid, DatabaseSchema dbSchema,
                                     List<Operation> operations)
            throws Throwable {
        String methodName = "transact";
        return getRequestStr(uuid, methodName,
                             ParamUtil.getTransactParams(dbSchema, operations));
    }
}
