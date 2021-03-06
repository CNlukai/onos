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
package org.onosproject.ovsdb.lib.error;

/**
 * This exception is thrown when the argument is not supported.
 */
public class ArgumentException extends RuntimeException {
    private static final long serialVersionUID = 4950089877540156797L;

    /**
     * Constructs a ArgumentException object.
     * @param message error message
     */
    public ArgumentException(String message) {
        super(message);
    }

    /**
     * Constructs a ArgumentException object.
     * @param message error message
     * @param cause Throwable
     */
    public ArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
