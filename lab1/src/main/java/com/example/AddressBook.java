package com.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class AddressBook {
    private ArrayList<BuddyInfo> buddies;

    public AddressBook() {
        this.buddies = new ArrayList<>();
    }

    public ArrayList<BuddyInfo> getBuddies() {
        return this.buddies;
    }

    public void addBuddies(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }
    public static void main( String[] args ) {
        BuddyInfo Bob = new BuddyInfo("Bob Dylan", "123456789");
        BuddyInfo Dylan = new BuddyInfo("Dylan Bob", "987654321");

        AddressBook book = new AddressBook();
        book.addBuddies(Bob);
        book.addBuddies(Dylan);

        for (int i = 0; i < book.getBuddies().size(); i++) {
            System.out.println("Buddy " + (i + 1) + ": ");
            System.out.println(book.getBuddies().get(i).getName());
            System.out.println(book.getBuddies().get(i).getNumber());
            System.out.println();
        }
    }
}
