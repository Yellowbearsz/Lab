package com.example.lab5.model;

import java.util.ArrayList;
import java.util.List;

public class NoteRepository {
    private static NoteRepository instance;
    private List<Note> noteList;
    private NoteRepository() {
        noteList = new ArrayList<>();
    }
    public static NoteRepository getInstance() {
        if (instance == null) {
            instance = new NoteRepository();
        }
        return instance;
    }
    public void addNote(Note note) {
        noteList.add(note);
    }
    public List<Note> getAllNotes() {
        return noteList;
    }
}