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

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Objects;

import com.google.common.collect.Lists;

/**
 * Josn Rpc Request information that include id,method,params.
 */
public class JsonRpcRequest {

    private final String id;
    private final String method;
    private final List<Object> params;

    /**
     * JsonRpcRequest Constructor.
     * @param id
     * @param method
     */
    public JsonRpcRequest(String id, String method) {
        checkNotNull(id, "id is not null");
        checkNotNull(method, "method is not null");
        this.id = id;
        this.method = method;
        this.params = Lists.newArrayList();
    }

    /**
     * JsonRpcRequest Constructor.
     * @param id
     * @param method
     * @param params
     */
    public JsonRpcRequest(String id, String method, List<Object> params) {
        checkNotNull(id, "id is not null");
        checkNotNull(method, "method is not null");
        checkNotNull(params, "params is not null");
        this.id = id;
        this.method = method;
        this.params = params;
    }

    /**
     * Returns id.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns method.
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Returns params.
     * @return params
     */
    public List<Object> getParams() {
        return params;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, method, params);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JsonRpcRequest) {
            final JsonRpcRequest other = (JsonRpcRequest) obj;
            return Objects.equals(this.id, other.id)
                    && Objects.equals(this.method, other.method)
                    && Objects.equals(this.params, other.params);
        }
        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("id", id).add("method", method)
                .add("params", params).toString();
    }
}
