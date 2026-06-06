package com.example.lab5.model;

public class Subscription extends User {
    private final String memberExpired;
    public Subscription(String name, String id, String memberExpired) {
        super(name, id);
        this.memberExpired = memberExpired;
    }

    @Override
    public void getPrivilege() {
        System.out.println("User: " + getName() + " [Subscription: Unlimited Storage, Expires: " + memberExpired + "]");
    }
    @Override
    public String getPrivilegeString() {
        return "Subscription: Unlimited Storage (Expires: " + memberExpired + ")";
    }
}