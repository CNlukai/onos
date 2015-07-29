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

import java.util.Stack;

/**
 * Context for decode parameters.
 */
public class JsonReadContext {
    private Stack<Byte> bufStack;
    private boolean isStartMatch;
    private int lastReadBytes;

    /**
     * Constructs a JsonReadContext object.
     * @param bufStack used for match the braces and double quotes
     * @param isStartMatch mark whether the matching has started
     * @param lastReadBytes the bytes for last decoding incomplete record
     */
    public JsonReadContext() {
        bufStack = new Stack<Byte>();
        isStartMatch = false;
        lastReadBytes = 0;
    }

    /**
     * Return bufStack.
     * @return bufStack
     */
    public Stack<Byte> getBufStack() {
        return bufStack;
    }

    /**
     * Set bufStack.
     * @param bufStack
     */
    public void setBufStack(Stack<Byte> bufStack) {
        this.bufStack = bufStack;
    }

    /**
     * Return isStartMatch.
     * @return isStartMatch
     */
    public boolean isStartMatch() {
        return isStartMatch;
    }

    /**
     * Set isStartMatch.
     * @param isStartMatch
     */
    public void setStartMatch(boolean isStartMatch) {
        this.isStartMatch = isStartMatch;
    }

    /**
     * Return lastReadBytes.
     * @return lastReadBytes
     */
    public int getLastReadBytes() {
        return lastReadBytes;
    }

    /**
     * Set lastReadBytes.
     * @param lastReadBytes
     */
    public void setLastReadBytes(int lastReadBytes) {
        this.lastReadBytes = lastReadBytes;
    }
}
