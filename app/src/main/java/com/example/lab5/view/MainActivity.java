package com.example.lab5.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab5.R;

public class MainActivity extends AppCompatActivity {

    private Button btnGoToAddNote;
    private Button btnGoToBrowse;
    private ProgressBar mainProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        btnGoToAddNote = findViewById(R.id.btnGoToAddNote);
        btnGoToBrowse = findViewById(R.id.btnGoToBrowse);
        mainProgressBar = findViewById(R.id.mainProgressBar);
        btnGoToAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });
        btnGoToBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainProgressBar.setVisibility(View.VISIBLE);
                btnGoToBrowse.setEnabled(false);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mainProgressBar.setVisibility(View.GONE);
                                btnGoToBrowse.setEnabled(true);
                                Intent intent = new Intent(MainActivity.this, BrowseNoteActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                }).start();
            }
        });
    }
}