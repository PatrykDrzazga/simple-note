package com.example.patryk.simplenote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    Button notesButton;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addButton = (Button) findViewById(R.id.addButton);
        notesButton = (Button) findViewById(R.id.notesButton);
        exitButton = (Button)findViewById(R.id.exitButton);




    }

    public void click(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.addButton:
                intent = new Intent(MainActivity.this, AddNew.class);
                startActivity(intent);
                break;
            case R.id.notesButton:
                intent = new Intent(MainActivity.this, ListNotes.class);
                startActivity(intent);
                break;
            case R.id.exitButton:
                finish();
                System.exit(0);
                break;
        }
    }




}
