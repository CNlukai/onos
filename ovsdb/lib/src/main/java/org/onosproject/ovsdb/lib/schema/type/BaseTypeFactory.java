package org.onosproject.ovsdb.lib.schema.type;

import java.util.Set;

import org.onosproject.ovsdb.lib.error.TypedSchemaException;
import org.onosproject.ovsdb.lib.schema.type.UuidBaseType.RefType;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Sets;

public final class BaseTypeFactory {

    private BaseTypeFactory() {
    }

    /**
     * Create a BaseType from the JsonNode.
     * @param json the BaseType JsonNode
     * @param keyorval the key node or value node
     * @return BaseType
     */
    public static BaseType getBaseTypeFromJson(JsonNode json, String keyorval) {
        if (json.isValueNode()) {
            String type = json.asText().trim();
            return fromTypeStr(type);
        } else {
            if (!json.has(keyorval)) {
                throw new TypedSchemaException("not a type");
            }
            return fromJsonNode(json.get(keyorval));
        }
    }

    /**
     * Get BaseType by the type value of JsonNode.
     * @param type the type value of JsonNode
     * @return BaseType
     */
    private static BaseType fromTypeStr(String type) {
        switch (type) {
        case "boolean":
            return new BooleanBaseType();
        case "integer":
            return new IntegerBaseType();
        case "real":
            return new RealBaseType();
        case "string":
            return new StringBaseType();
        case "uuid":
            return new UuidBaseType();
        default:
            return null;
        }
    }

    /**
     * json like "string" or json like {"type" : "string", "enum": ["set",
     * ["access", "native-tagged"]]}" for key or value.
     * @param type JsonNode
     */
    private static BaseType fromJsonNode(JsonNode type) {
        if (type.isTextual()) {
            return fromTypeStr(type.asText());
        } else if (type.isObject() && type.has("type")) {
            String typeStr = type.get("type").asText();
            switch (typeStr) {
            case "boolean":
                return new BooleanBaseType();
            case "integer":
                return getIntegerBaseType(type);
            case "real":
                return getRealBaseType(type);
            case "string":
                return getStringBaseType(type);
            case "uuid":
                return getUuidBaseType(type);
            default:
                return null;
            }
        }
        return null;
    }

    /**
     * Get IntegerBaseType by the type value of JsonNode which contains the
     * constraints.
     * @param type the type value of JsonNode
     * @return IntegerBaseType
     */
    private static IntegerBaseType getIntegerBaseType(JsonNode type) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        Set<Integer> enums = Sets.newHashSet();
        JsonNode node = type.get("minInteger");
        if (node != null) {
            min = node.asInt();
        }
        node = type.get("maxInteger");
        if (node != null) {
            max = node.asInt();
        }
        if (node.has("enum")) {
            JsonNode anEnum = node.get("enum").get(1);
            for (JsonNode n : anEnum) {
                enums.add(n.asInt());
            }
        }
        return new IntegerBaseType(min, max, enums);
    }

    /**
     * Get RealBaseType by the type value of JsonNode which contains the
     * constraints.
     * @param type the type value of JsonNode
     * @return RealBaseType
     */
    private static RealBaseType getRealBaseType(JsonNode type) {
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        Set<Double> enums = Sets.newHashSet();
        JsonNode node = type.get("minReal");
        if (node != null) {
            min = node.asDouble();
        }
        node = type.get("maxReal");
        if (node != null) {
            max = node.asDouble();
        }
        if (node.has("enum")) {
            JsonNode anEnum = node.get("enum").get(1);
            for (JsonNode n : anEnum) {
                enums.add(n.asDouble());
            }
        }
        return new RealBaseType(min, max, enums);
    }

    /**
     * Get StringBaseType by the type value of JsonNode which contains the
     * constraints.
     * @param type the type value of JsonNode
     * @return StringBaseType
     */
    private static StringBaseType getStringBaseType(JsonNode type) {
        int minLength = Integer.MIN_VALUE;
        int maxLength = Integer.MAX_VALUE;
        Set<String> enums = Sets.newHashSet();
        JsonNode node = type.get("minLength");
        if (node != null) {
            minLength = node.asInt();
        }
        node = type.get("maxLength");
        if (node != null) {
            maxLength = node.asInt();
        }
        if (node.has("enum")) {
            JsonNode enumVal = node.get("enum");
            if (enumVal.isArray()) {
                JsonNode anEnum = enumVal.get(1);
                for (JsonNode n : anEnum) {
                    enums.add(n.asText());
                }
            } else if (enumVal.isTextual()) {
                enums.add(enumVal.asText());
            }
        }
        return new StringBaseType(minLength, maxLength, enums);
    }

    /**
     * Get UuidBaseType by the type value of JsonNode which contains the
     * constraints.
     * @param type the type value of JsonNode
     * @return UuidBaseType
     */
    private static UuidBaseType getUuidBaseType(JsonNode type) {
        String refTable = null;
        String refType = RefType.STRONG.getName();
        JsonNode node = type.get("refTable");
        if (node != null) {
            refTable = node.asText();
        }
        node = type.get("refType");
        if (node != null) {
            refType = node.asText();
        }
        return new UuidBaseType(refTable, refType);
    }
}
