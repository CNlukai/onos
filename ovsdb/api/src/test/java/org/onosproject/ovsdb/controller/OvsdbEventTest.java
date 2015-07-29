package org.onosproject.ovsdb.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.onlab.junit.ImmutableClassChecker.assertThatClassIsImmutable;

import org.junit.Test;

import com.google.common.testing.EqualsTester;

/**
 * Unit tests for OvsdbEvent class.
 */
public class OvsdbEventTest {
    final OvsdbEvent<String> event1 = new OvsdbEvent<String>(
                                                             OvsdbEvent.Type.PORT_ADDED,
                                                             "1");
    final OvsdbEvent<String> sameEvent1 = new OvsdbEvent<String>(
                                                                 OvsdbEvent.Type.PORT_ADDED,
                                                                 "1");
    final OvsdbEvent<String> event2 = new OvsdbEvent<String>(
                                                             OvsdbEvent.Type.PORT_REMOVED,
                                                             "2");

    /**
     * Checks that the NodeId class is immutable.
     */
    @Test
    public void testImmutability() {
        assertThatClassIsImmutable(OvsdbEvent.class);
    }

    /**
     * Checks the operation of equals().
     */
    @Test
    public void testEquals() {
        new EqualsTester().addEqualityGroup(event1)
                .addEqualityGroup(sameEvent1).addEqualityGroup(event2)
                .testEquals();
    }

    /**
     * Checks the construction of a OvsdbEvent object.
     */
    @Test
    public void testConstruction() {
        final String eventValue = "subject";
        final OvsdbEvent<String> event = new OvsdbEvent<String>(
                                                                OvsdbEvent.Type.PORT_ADDED,
                                                                eventValue);
        assertThat(event, is(notNullValue()));
        assertThat(event.type(), is(OvsdbEvent.Type.PORT_ADDED));
        assertThat(event.subject(), is(eventValue));

    }
}
