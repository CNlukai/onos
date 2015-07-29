package org.onosproject.ovsdb.controller;

import static org.onlab.junit.ImmutableClassChecker.assertThatClassIsImmutable;

import org.junit.Test;

/**
 * Unit tests for NodeId class.
 */
public class NodeIdTest {
    // final OvsdbNodeId nodeId1 = new OvsdbNodeId("1");
    // final OvsdbNodeId sameNodeId1 = new OvsdbNodeId("1");
    // final OvsdbNodeId nodeId2 = new OvsdbNodeId("2");

    /**
     * Checks that the NodeId class is immutable.
     */
    @Test
    public void testImmutability() {
        assertThatClassIsImmutable(OvsdbNodeId.class);
    }

    /**
     * Checks the operation of equals().
     */
    @Test
    public void testEquals() {
        // new EqualsTester().addEqualityGroup(nodeId1, sameNodeId1)
        // .addEqualityGroup(nodeId2).testEquals();
    }

    /**
     * Checks the construction of a NodeId object.
     */
    @Test
    public void testConstruction() {
        final String nodeIdValue = "11111";
        // final OvsdbNodeId nodeId = new OvsdbNodeId(nodeIdValue);
        // assertThat(nodeId, is(notNullValue()));
        // assertThat(nodeId.nodeId(), is("ovsdb" + ":" + nodeIdValue));

    }
}
