package com.example.lab5.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5.R;
import com.example.lab5.controller.NoteController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddNoteActivity extends AppCompatActivity {

    private EditText etUserName, etUserId, etMemberExpired, etNoteTitle, etNoteContent;
    private RadioGroup rgUserType, rgNoteType;
    private Button btnSave;
    private NoteController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        controller = new NoteController();
        etUserName = findViewById(R.id.etUserName);
        etUserId = findViewById(R.id.etUserId);
        etMemberExpired = findViewById(R.id.etMemberExpired);
        etNoteTitle = findViewById(R.id.etNoteTitle);
        etNoteContent = findViewById(R.id.etNoteContent);
        rgUserType = findViewById(R.id.rgUserType);
        rgNoteType = findViewById(R.id.rgNoteType);
        btnSave = findViewById(R.id.btnSave);
        rgUserType.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbPremiumUser) {
                etMemberExpired.setVisibility(View.VISIBLE);
            } else {
                etMemberExpired.setVisibility(View.GONE);
            }
        });
        rgNoteType.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbChecklistNote) {
                etNoteContent.setHint("ChecklistNote");
            } else {
                etNoteContent.setHint("ใส่เนื้อหาข้อความโน๊ตที่นี่");
            }
        });
        btnSave.setOnClickListener(v -> {
            String name = etUserName.getText().toString().trim();
            String userId = etUserId.getText().toString().trim();
            String title = etNoteTitle.getText().toString().trim();
            String content = etNoteContent.getText().toString().trim();
            String expiredDate = etMemberExpired.getText().toString().trim();
            if (name.isEmpty() || userId.isEmpty() || title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "กรุณากรอกข้อมูลสำคัญให้ครบถ้วน", Toast.LENGTH_SHORT).show();
                return;
            }
            String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            boolean isPremium = (rgUserType.getCheckedRadioButtonId() == R.id.rbPremiumUser);
            boolean isChecklist = (rgNoteType.getCheckedRadioButtonId() == R.id.rbChecklistNote);
            if (isChecklist) {
                controller.createCheckListNote(title, currentDate, content, name, userId, isPremium, expiredDate);
            } else {
                controller.createTextNote(title, currentDate, content, name, userId, isPremium, expiredDate);
            }
            Toast.makeText(this, "Savenote", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}