package com.example.dream.music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dream.music.DB.MusicDb;

import java.util.List;

public class MusicAdapter extends ArrayAdapter<MusicDb> {

    private int resourceId;

    public MusicAdapter(Context context, int textViewResourceId, List<MusicDb> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MusicDb musicDb = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView musicTitle = (TextView) view.findViewById(R.id.name);
        TextView singer = (TextView) view.findViewById(R.id.singer);
        musicTitle.setText(musicDb.getTitle());
        singer.setText(musicDb.getSinger());
        return view;
    }
}
