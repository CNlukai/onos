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

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * ObjectMapper utility class.
 */
public final class ObjectMapperUtil {

    private ObjectMapperUtil() {
    }

    /**
     * get ObjectMapper.
     * @return ObjectMapper
     */
    public static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                           false);
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        return objectMapper;
    }

    /**
     * get ObjectMapper.
     * @param flag configure
     * @return ObjectMapper
     */
    public static ObjectMapper getObjectMapper(boolean flag) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                           flag);
        return objectMapper;
    }

    /**
     * get ObjectMapper.
     * @param flag configure
     * @param incl setSerializationInclusion
     * @return
     */
    public static ObjectMapper getObjectMapper(boolean flag, Include incl) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                           flag);
        objectMapper.setSerializationInclusion(incl);
        return objectMapper;
    }

    /**
     * convert Object into String.
     * @param obj Object
     * @return String
     */
    public static String convertToString(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
