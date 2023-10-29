package com.example.lab6;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AddressBook {
    @Id
    private long id;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddies;

    public AddressBook() {}

    public AddressBook(List<BuddyInfo> buddies, Integer id) {
        this.buddies = buddies;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}

