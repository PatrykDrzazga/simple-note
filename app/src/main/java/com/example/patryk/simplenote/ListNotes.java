package com.example.patryk.simplenote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListNotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);
        fillListview();

    }

    public void fillListview() {
        ListView myListview = findViewById(R.id.listview);
        DatabaseHelper dbhelper = new DatabaseHelper(this);

        ArrayList<Note> NoteList = dbhelper.getAllData();

        NoteAdapter myAdapter = new NoteAdapter(this,NoteList);
        myListview.setAdapter(myAdapter);
    }
}
