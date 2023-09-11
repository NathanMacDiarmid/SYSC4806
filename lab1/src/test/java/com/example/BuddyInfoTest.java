package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BuddyInfoTest {
    private BuddyInfo Bob = new BuddyInfo("Bob Dylan", "123456789");
    private BuddyInfo Dylan = new BuddyInfo("Dylan Bob", "987654321");

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testName() {
        assertTrue( Bob.getName().equals("Bob Dylan") );
        assertTrue( Dylan.getName().equals("Dylan Bob") );
    }

    @Test
    public void testNumber() {
        assertTrue( Bob.getNumber().equals("123456789") );
        assertTrue( Dylan.getNumber().equals("987654321") );
    }
}
