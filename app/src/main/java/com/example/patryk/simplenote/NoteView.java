package com.example.patryk.simplenote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NoteView extends AppCompatActivity {

    DatabaseHelper db;
    Note note;

    EditText title, note_edit;
    TextView date;
    Button delete, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_view);

        title = findViewById(R.id.title_edit);
        note_edit = findViewById(R.id.note_edit);
        date = findViewById(R.id.date_mod);
        delete = findViewById(R.id.delete);
        save = findViewById(R.id.save);

        note = (Note) getIntent().getExtras().getSerializable("Notatka");

        title.setText(note.getTitle());
        note_edit.setText(note.getNote());
        date.setText("Ostatnia modyfikacja: " + note.getDate());


        db = new DatabaseHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteNote(note);
                Toast.makeText(NoteView.this, R.string.delete_success, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NoteView.this, ListNotes.class);
                finish();
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTitle = String.valueOf(title.getText());
                String newNote = String.valueOf(note_edit.getText());
                db.updateNote(note, newTitle, newNote);
                Toast.makeText(NoteView.this, R.string.update_success, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NoteView.this, ListNotes.class);
                finish();
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NoteView.this, ListNotes.class);
        finish();
        startActivity(intent);
    }
}
