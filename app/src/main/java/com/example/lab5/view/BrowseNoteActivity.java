package com.example.lab5.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab5.R;

import com.example.lab5.controller.NoteController;
import com.example.lab5.model.Note;
import java.util.List;

public class BrowseNoteActivity extends AppCompatActivity {

    private EditText etSearchQuery;
    private Button btnSearch;
    private ProgressBar searchProgressBar;
    private TextView tvSearchResult;
    private NoteController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_note);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        controller = new NoteController();
        etSearchQuery = findViewById(R.id.etSearchQuery);
        btnSearch = findViewById(R.id.btnSearch);
        searchProgressBar = findViewById(R.id.searchProgressBar);
        tvSearchResult = findViewById(R.id.tvSearchResult);

        displayAllNotes();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = etSearchQuery.getText().toString().trim();
                tvSearchResult.setText("");
                searchProgressBar.setVisibility(View.VISIBLE);
                searchProgressBar.setIndeterminate(true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        
                        List<Note> allNotes = controller.getNotes();
                        StringBuilder result = new StringBuilder();
                        for (Note note : allNotes) {
                            if (query.isEmpty() || note.getTitle().toLowerCase().contains(query.toLowerCase())) {
                                result.append(note.getSummaryString()).append("\n\n-------------------\n\n");
                            }
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                searchProgressBar.setVisibility(View.GONE);
                                if (result.length() > 0) {
                                    tvSearchResult.setText(result.toString());
                                } else {
                                    tvSearchResult.setText("ไม่พบข้อมูล");
                                }
                            }
                        });
                    }
                }).start();
            }
        });
    }

    private void displayAllNotes() {
        List<Note> allNotes = controller.getNotes();
        if (allNotes.isEmpty()) {
            tvSearchResult.setText("ไม่มีโน้ตที่บันทึกไว้");
            return;
        }
        StringBuilder result = new StringBuilder();
        for (Note note : allNotes) {
            result.append(note.getSummaryString()).append("\n\n-------------------\n\n");
        }
        tvSearchResult.setText(result.toString());
    }
}