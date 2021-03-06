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
package org.onosproject.ovsdb.lib.schema.type;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;
import java.util.Objects;

import org.onosproject.ovsdb.lib.notation.OvsdbMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;

/**
 * a JSON object that describes the type of a database column, with key and
 * value. Refer to RFC 7047 Section 3.2.
 */
public class KeyValuedColumnType implements ColumnType {
    private final BaseType keyType;
    private final BaseType valueType;
    private final int min;
    private final int max;

    /**
     * Constructs a KeyValuedColumnType object.
     * @param keyType BaseType entity
     * @param valueType BaseType entity
     * @param min min constraint
     * @param max max constraint
     */
    public KeyValuedColumnType(BaseType keyType, BaseType valueType, int min,
                               int max) {
        checkNotNull(keyType, "keyType is not null");
        checkNotNull(valueType, "valueType is not null");
        this.keyType = keyType;
        this.valueType = valueType;
        this.min = min;
        this.max = max;
    }

    @Override
    public Object getValueFromJson(JsonNode json) {
        if (json.isArray()) {
            if (json.size() == 2) {
                if (json.get(0).isTextual()
                        && "map".equals(json.get(0).asText())) {
                    Map map = Maps.newHashMap();
                    for (JsonNode pairNode : json.get(1)) {
                        if (pairNode.isArray() && json.size() == 2) {
                            Object key = keyType().toValue(pairNode.get(0));
                            Object value = valueType().toValue(pairNode.get(1));
                            map.put(key, value);
                        }
                    }
                    return OvsdbMap.ovsdbMap(map);
                } else if (json.size() == 0) {
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * Get keyType.
     * @return keyType
     */
    public BaseType keyType() {
        return keyType;
    }

    /**
     * Get valueType.
     * @return valueType
     */
    public BaseType valueType() {
        return valueType;
    }

    /**
     * Get min.
     * @return min
     */
    public int min() {
        return min;
    }

    /**
     * Get max.
     * @return max
     */
    public int max() {
        return max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyType, valueType, min, max);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KeyValuedColumnType) {
            final KeyValuedColumnType other = (KeyValuedColumnType) obj;
            return Objects.equals(this.keyType, other.keyType)
                    && Objects.equals(this.valueType, other.valueType)
                    && Objects.equals(this.min, other.min)
                    && Objects.equals(this.max, other.max);
        }
        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("keyType", keyType)
                .add("valueType", valueType).add("min", min).add("max", max)
                .toString();
    }
}
