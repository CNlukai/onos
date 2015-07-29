package org.onosproject.ovsdb.lib.schema.type;

import org.onosproject.ovsdb.lib.error.TypedSchemaException;
import org.onosproject.ovsdb.lib.utils.ObjectMapperUtil;

import com.fasterxml.jackson.databind.JsonNode;

public final class ColumnTypeFactory {

    private ColumnTypeFactory() {
    }

    /**
     * "flow_tables":{"type":{"key":{"maxInteger":254,"minInteger":0,"type":
     * "integer"},"min":0,"value":{"type":"uuid","refTable":"Flow_Table"},"max":
     * "unlimited"}}.
     * @param json the ColumnType JsonNode
     * @return ColumnType
     */
    public static ColumnType getColumnTypeFromJson(JsonNode json) {
        if (json.isObject() && !json.has("value")) {
            return createAtomicColumnType(json);
        } else if (!json.isValueNode() && json.has("value")) {
            return createKeyValuedColumnType(json);
        }
        throw new TypedSchemaException("could not find the right column type :"
                + ObjectMapperUtil.convertToString(json));
    }

    /**
     * Create AtomicColumnType entity.
     * @param json JsonNode
     * @return AtomicColumnType entity
     */
    private static AtomicColumnType createAtomicColumnType(JsonNode json) {
        BaseType baseType = BaseTypeFactory.getBaseTypeFromJson(json, "key");
        int min = 1;
        int max = 1;
        JsonNode node = json.get("min");
        if (node != null) {
            min = node.asInt();
        }
        node = json.get("max");
        if (node != null) {
            if (node.isNumber()) {
                max = node.asInt();
            } else if (node.isTextual() && "unlimited".equals(node.asText())) {
                max = Integer.MAX_VALUE;
            }
        }
        return new AtomicColumnType(baseType, min, max);
    }

    /**
     * Create KeyValuedColumnType entity.
     * @param json JsonNode
     * @return KeyValuedColumnType entity
     */
    private static KeyValuedColumnType createKeyValuedColumnType(JsonNode json) {
        BaseType keyType = BaseTypeFactory.getBaseTypeFromJson(json, "key");
        BaseType valueType = BaseTypeFactory.getBaseTypeFromJson(json, "value");
        int min = 1;
        int max = 1;
        JsonNode node = json.get("min");
        if (node != null) {
            min = node.asInt();
        }
        node = json.get("max");
        if (node != null) {
            if (node.isNumber()) {
                max = node.asInt();
            } else if (node.isTextual() && "unlimited".equals(node.asText())) {
                max = Integer.MAX_VALUE;
            }
        }
        return new KeyValuedColumnType(keyType, valueType, min, max);
    }
}
