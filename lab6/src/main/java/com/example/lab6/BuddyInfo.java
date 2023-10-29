package com.example.lab6;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    private long id;
    private String number;
    private String name;
    private String submit;

    public BuddyInfo() {}

    public BuddyInfo(String buddyName, String buddyNumber, int id) {
        this.name = buddyName;
        this.number = buddyNumber;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSubmit() {
        return this.submit;
    }
    
    public void setSubmit(String submit) {
        this.submit = submit;
    }
}
