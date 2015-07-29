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

import org.onosproject.ovsdb.lib.notation.Condition;
import org.onosproject.ovsdb.lib.notation.Condition.Function;

/**
 * Condition utility class.
 */
public final class ConditionUtil {

    private ConditionUtil() {
    }

    /**
     * Returns a Condition that means == .
     * @param columnName column name
     * @param data column value
     * @return Condition
     */
    public static Condition equals(String columnName, Object data) {
        Object value = TransValueUtil.getFormatData(data);
        return new Condition(columnName, Function.EQUALS, value);
    }

    /**
     * Returns a Condition that means != .
     * @param columnName column name
     * @param data column value
     * @return Condition
     */
    public static Condition unEquals(String columnName, Object data) {
        Object value = TransValueUtil.getFormatData(data);
        return new Condition(columnName, Function.NOT_EQUALS, value);
    }

    /**
     * Returns a Condition that means > .
     * @param columnName column name
     * @param data column value
     * @return Condition
     */
    public static Condition greaterThan(String columnName, Object data) {
        Object value = TransValueUtil.getFormatData(data);
        return new Condition(columnName, Function.GREATER_THAN, value);
    }

    /**
     * Returns a Condition that means >= .
     * @param columnName column name
     * @param data column value
     * @return Condition
     */
    public static Condition greaterThanOrEquals(String columnName, Object data) {
        Object value = TransValueUtil.getFormatData(data);
        return new Condition(columnName, Function.GREATER_THAN_OR_EQUALS, value);
    }

    /**
     * Returns a Condition that means < .
     * @param columnName column name
     * @param data column value
     * @return Condition
     */
    public static Condition lesserThan(String columnName, Object data) {
        Object value = TransValueUtil.getFormatData(data);
        return new Condition(columnName, Function.LESS_THAN, value);
    }

    /**
     * Returns a Condition that means <= .
     * @param columnName column name
     * @param data column value
     * @return Condition
     */
    public static Condition lesserThanOrEquals(String columnName, Object data) {
        Object value = TransValueUtil.getFormatData(data);
        return new Condition(columnName, Function.LESS_THAN_OR_EQUALS, value);
    }

    /**
     * Returns a Condition that means includes .
     * @param columnName column name
     * @param data column value
     * @return Condition
     */
    public static Condition includes(String columnName, Object data) {
        Object value = TransValueUtil.getFormatData(data);
        return new Condition(columnName, Function.INCLUDES, value);
    }

    /**
     * Returns a Condition that means excludes .
     * @param columnName column name
     * @param data column value
     * @return Condition
     */
    public static Condition excludes(String columnName, Object data) {
        Object value = TransValueUtil.getFormatData(data);
        return new Condition(columnName, Function.EXCLUDES, value);
    }

}
