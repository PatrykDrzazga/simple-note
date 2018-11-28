package com.example.patryk.simplenote;

import java.io.Serializable;

public class Note implements Serializable {
    private int icon;
    private String id;
    private String title;
    private String note;
    private String date;

    public Note(String title, String date){
        this.title=title;
        this.date=date;
    }

    public Note(String id,String title,String note, String date){
        this.id=id;
        this.title=title;
        this.note=note;
        this.date=date;
    }


    public int getIcon(){
        return icon;
    }

    public void setIcon(){
        this.icon = icon;
    }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(){
        this.title = title;
    }

    public String getNote(){
        return note;
    }

    public void setNote(){
        this.note = note;
    }

    public String getDate(){
        return date;
    }

    public void setDate(){
        this.date=date;
    }
}
