package com.example.lab5.model;

public class TextNote extends Note {
    private String message;
    public TextNote(String title, String createdDate, String message, User owner) {
        super(title, createdDate, owner);
        this.message = message;
    }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    @Override
    public void getSummary() {
        System.out.println("Text Note: " + getTitle() + " | Content: " + message);
    }
    @Override
    public String getSummaryString() {
        return "Text Note: " + getTitle() + "\n" +
                "Date: " + getCreatedDate() + "\n" +
                "Content: " + message + "\n" +
                "By: " + getOwner().getName() + " (ID: " + getOwner().getId() + ")\n" +
                "Status: " + getOwner().getPrivilegeString();
    }
}