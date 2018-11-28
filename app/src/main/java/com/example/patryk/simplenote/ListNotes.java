package com.example.patryk.simplenote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListNotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);
        fillListview();


    }

    public void fillListview() {
        final ListView myListview = findViewById(R.id.listview);
        DatabaseHelper dbhelper = new DatabaseHelper(this);

        final ArrayList<Note> NoteList = dbhelper.getAllData();

        final NoteAdapter myAdapter = new NoteAdapter(this,NoteList);
        myListview.setAdapter(myAdapter);

        myListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = NoteList.get(position);
                Intent intent = new Intent(ListNotes.this, NoteView.class);
                intent.putExtra("Notatka",note);
                startActivity(intent);
                finish();




            }
        });
    }
}
