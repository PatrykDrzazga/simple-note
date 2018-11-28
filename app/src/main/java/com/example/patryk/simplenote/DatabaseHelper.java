package com.example.patryk.simplenote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "note.db";

    public static final String TABLE_NAME = "note_table";
    public static final String COL_ID = "id";
    public static final String COL_TITLE = "title";
    public static final String COL_NOTE = "note";
    public static final String COL_DATE = "date";


    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_TITLE + " TEXT,"
                    + COL_NOTE+ " TEXT,"
                    + COL_DATE + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";



    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addNote(String title, String note){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_TITLE, title);
        values.put(COL_NOTE, note);

        long row = db.insert(TABLE_NAME, null, values);
        db.close();

        return row;
    }

    public ArrayList<Note> getAllData() {
        ArrayList<Note> notelist = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME + " ORDER BY " +
                COL_DATE + " DESC",null);

        while(res.moveToNext()) {
            String id = res.getString(0);
            String title = res.getString(1);
            String note = res.getString(2);
            String date = res.getString(3);

            Note newNote = new Note(id, title, note, date);
            notelist.add(newNote);
        }
        return notelist;
    }

    public void deleteNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COL_ID + " = ?", new String[]{String.valueOf(note.getId())});
        db.close();
    }

    public int updateNote(Note note, String title, String notes){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_TITLE, title);
        values.put(COL_NOTE, notes);
        values.put(COL_DATE, currentDateandTime);
        return db.update(TABLE_NAME, values, COL_ID + " = ?", new String[]{String.valueOf(note.getId())});
    }
}
