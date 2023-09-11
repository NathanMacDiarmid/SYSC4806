package com.example;

public class BuddyInfo {
    private String name;
    private String number;

    public BuddyInfo(String buddyName, String buddyNumber) {
        name = buddyName;
        number = buddyNumber;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
