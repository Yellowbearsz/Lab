package com.example.lab5.controller;

import com.example.lab5.model.*;
import java.util.List;

public class NoteController {
    private NoteRepository repository;

    public NoteController() {
        this.repository = NoteRepository.getInstance();
    }

    public void createTextNote(String title, String date, String content, String name, String userId, boolean isPremium, String expiredDate) {
        User owner = isPremium ? new PremiumUser(name, userId, expiredDate) : new FreeUser(name, userId);
        TextNote textNote = new TextNote(title, date, content, owner);
        repository.addNote(textNote);
    }

    public void createCheckListNote(String title, String date, String items, String name, String userId, boolean isPremium, String expiredDate) {
        User owner = isPremium ? new PremiumUser(name, userId, expiredDate) : new FreeUser(name, userId);
        CheckListNote checkListNote = new CheckListNote(title, date, items, owner);
        repository.addNote(checkListNote);
    }

    public List<Note> getNotes() {
        return repository.getAllNotes();
    }
}