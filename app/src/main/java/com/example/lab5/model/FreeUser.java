package com.example.lab5.model;

public class FreeUser extends User {
    public FreeUser(String name, String id) {
        super(name, id);
    }
    @Override
    public void getPrivilege() {
        System.out.println("User: " + getName() + " [Free Tier: Limited Storage]");
    }
    @Override
    public String getPrivilegeString() {
        return "Free Tier: Limited Storage";
    }
}