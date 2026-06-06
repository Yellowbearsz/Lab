package com.example.lab5.model;

public class PremiumUser extends User {
    private String memberExpired;
    public PremiumUser(String name, String id, String memberExpired) {
        super(name, id);
        this.memberExpired = memberExpired;
    }
    public String getMemberExpired() { return memberExpired; }

    @Override
    public void getPrivilege() {
        System.out.println("User: " + getName() + " [Premium Tier: Unlimited Storage, Expires: " + memberExpired + "]");
    }
    @Override
    public String getPrivilegeString() {
        return "Premium Tier: Unlimited Storage (Expires: " + memberExpired + ")";
    }
}