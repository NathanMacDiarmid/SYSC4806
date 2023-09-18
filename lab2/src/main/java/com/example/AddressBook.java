package com.example;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AddressBook {
    @Id
    private Integer bookID = null;

    @OneToMany (cascade = CascadeType.ALL)
    private List<BuddyInfo> buddies;

    public AddressBook() {
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(int id) {
        this.bookID = id;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public void addBuddies(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }

    public List<BuddyInfo> getBuddies() {
        return this.buddies;
    }

    public static void main( String[] args ) {
        JPATest jpa = new JPATest();
        jpa.performJPA();
    }
}
