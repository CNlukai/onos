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
package org.onosproject.ovsdb.lib.message;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.notation.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * All results of ovs table operations.
 * refer to RFC7047 5.2
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperationResult {
    private int count;
    @JsonIgnore
    private UUID uuid;
    private List<Row> rows;
    private String error;
    private String details;

    /**
     * Return count.
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * Set count value.
     * @param count the Operation message of count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Return uuid.
     * @return uuid
     */
    @JsonProperty("uuid")
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Set uuid value.
     * @param uuid the Operation message of uuid
     */
    public void setUuid(String uuid) {
        checkNotNull(uuid, "uuid is not null");
        this.uuid = UUID.uuid(uuid);
    }

    /**
     * Return Rows.
     * @return List<Row>
     */
    public List<Row> getRows() {
        return rows;
    }

    /**
     * Set rows value.
     * @param rows the Operation message of rows
     */
    public void setRows(List<Row> rows) {
        checkNotNull(rows, "rows is not null");
        this.rows = rows;
    }

    /**
     * Return error.
     * @return error
     */
    public String getError() {
        return error;
    }

    /**
     * Set error value.
     * @param error the Operation message of error
     */
    public void setError(String error) {
        checkNotNull(error, "error is not null");
        this.error = error;
    }

    /**
     * Return details.
     * @return details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Set details value.
     * @param details the Operation message of details
     */
    public void setDetails(String details) {
        checkNotNull(details, "details is not null");
        this.details = details;
    }
}
