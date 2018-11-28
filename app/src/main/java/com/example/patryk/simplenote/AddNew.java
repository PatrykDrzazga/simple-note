package com.example.patryk.simplenote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNew extends AppCompatActivity {

    DatabaseHelper db;

    Button save;
    EditText add_title;
    EditText add_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        db = new DatabaseHelper(this);

        save = findViewById(R.id.save_button);
        add_title = findViewById(R.id.add_title);
        add_note = findViewById(R.id.add_note);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = add_title.getText().toString();
                String note = add_note.getText().toString();
                if(title.equals("") || note.equals("")){
                    Toast.makeText(AddNew.this, R.string.add_error, Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addNote(title,note);
                    Toast.makeText(AddNew.this, R.string.add_success, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddNew.this, ListNotes.class);
                    finish();
                    startActivity(intent);
                }
            }
        });

    }
}
