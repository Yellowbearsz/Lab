package com.example.lab5.model;

public class CheckListNote extends Note {
    private String items;

    public CheckListNote(String title, String createdDate, String items, User owner) {
        super(title, createdDate, owner);
        this.items = items;
    }

    public String getItems() { return items; }
    public void setItems(String items) { this.items = items; }

    @Override
    public void getSummary() {
        System.out.println("Checklist Note: " + getTitle() + " | Items: " + items);
    }

    @Override
    public String getSummaryString() {
        return "Checklist: " + getTitle() + "\n" +
                "Date: " + getCreatedDate() + "\n" +
                "Items: " + items + "\n" +
                "By: " + getOwner().getName() + " (ID: " + getOwner().getId() + ")\n" +
                "Status: " + getOwner().getPrivilegeString();
    }
}
