package com.example.patryk.simplenote;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note> {

    private List<Note> data;
    private Context context;

    public NoteAdapter(Context context, ArrayList<Note> data) {
        super(context, R.layout.list_view_row);
        this.data=data;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        NoteHolder holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(R.layout.list_view_row, null);

            holder = new NoteHolder();
            holder.icon = (ImageView) row.findViewById(R.id.icon);
            holder.title = (TextView) row.findViewById(R.id.title);
            holder.date = (TextView) row.findViewById(R.id.date);

            row.setTag(holder);
        } else{
            holder = (NoteHolder) row.getTag();
        }

        holder.title.setText(data.get(position).getTitle());
        holder.date.setText(data.get(position).getDate());

        return row;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    static class NoteHolder{
        ImageView icon;
        TextView title;
        TextView date;
    }
}
