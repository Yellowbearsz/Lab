package com.example.lab5.model;

public abstract class Note {
    private String title;
    private String createdDate;
    private User owner;

    public Note(String title, String createdDate, User owner) {
        this.title = title;
        this.createdDate = createdDate;
        this.owner = owner;
    }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
    public abstract void getSummary();
    public abstract String getSummaryString();
}