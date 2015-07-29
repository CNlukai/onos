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
 * Json Rpc Response information that include id,error,result.
 */
public class JsonRpcResponse {

    private final String id;
    private final String error;
    private final List<Object> result;

    /**
     * JsonRpcResponse Constructor.
     * @param id
     * @param error
     */
    public JsonRpcResponse(String id, String error) {
        checkNotNull(id, "id is not null");
        this.id = id;
        this.error = error;
        this.result = Lists.newArrayList();
    }

    /**
     * JsonRpcResponse Constructor.
     * @param id
     * @param error
     * @param result
     */
    public JsonRpcResponse(String id, String error, List<Object> result) {
        checkNotNull(id, "id is not null");
        checkNotNull(result, "result is not null");
        this.id = id;
        this.error = error;
        this.result = result;
    }

    /**
     * Returns id.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns error.
     * @return error
     */
    public String getError() {
        return error;
    }

    /**
     * Returns result.
     * @return result
     */
    public List<Object> getResult() {
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, error, result);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JsonRpcResponse) {
            final JsonRpcResponse other = (JsonRpcResponse) obj;
            return Objects.equals(this.id, other.id)
                    && Objects.equals(this.error, other.error)
                    && Objects.equals(this.result, other.result);
        }
        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("id", id).add("error", error)
                .add("result", result).toString();
    }
}
