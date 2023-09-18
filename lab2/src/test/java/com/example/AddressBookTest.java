package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AddressBookTest {
    private BuddyInfo Bob = new BuddyInfo("Bob Dylan", "123456789", 1);
    private BuddyInfo Dylan = new BuddyInfo("Dylan Bob", "987654321", 2);
    private AddressBook book = new AddressBook();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void buddyAdded() {
        assertEquals(0, book.getBuddies().size());
        book.addBuddies(Bob);
        assertEquals(1, book.getBuddies().size());
        book.addBuddies(Dylan);
        assertEquals(2, book.getBuddies().size());
    }
}
