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

import java.util.Map;
import java.util.Set;

import org.onosproject.ovsdb.lib.notation.OvsdbMap;
import org.onosproject.ovsdb.lib.notation.OvsdbSet;

/**
 * Object value utility class.
 */
public final class TransValueUtil {

    private TransValueUtil() {
    }

    /**
     * if the type is Set, convert into OvsdbSet, if Map, convert into OvsdbMap.
     * @param value Object
     * @return
     */
    public static Object getFormatData(Object value) {
        if (value instanceof Map) {
            return OvsdbMap.ovsdbMap((Map) value);
        } else if (value instanceof Set) {
            return OvsdbSet.ovsdbSet((Set) value);
        } else {
            return value;
        }
    }
}
