package com.example.lab5.model;

public class GeneralPublic extends User {
    public GeneralPublic(String name, String id) {
        super(name, id);
    }
    @Override
    public void getPrivilege() {
        System.out.println("User: " + getName() + " [General Public: Limited Storage]");
    }
    @Override
    public String getPrivilegeString() {
        return "General Public: Limited Storage";
    }
}