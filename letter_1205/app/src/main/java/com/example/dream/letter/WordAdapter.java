package com.example.dream.letter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<FindWord> {
    private int resourceId;

    public WordAdapter(Context context, int textViewResourceId, List<FindWord>objects){
  super(context,textViewResourceId,objects);
  resourceId=textViewResourceId;
    }

    public View getView(int position, View convertView,  ViewGroup parent) {
       FindWord findWord=getItem(position);
       View view;
       if(convertView == null){
           view =LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
       }else {
           view = convertView;
       }
        TextView wordsname=(TextView) view.findViewById(R.id.noteTitle);
        TextView wordsmeaning=(TextView) view.findViewById(R.id.noteCreateTime);
        wordsname.setText(findWord.getName());
        wordsmeaning.setText(findWord.getMeaning());
        return view;
    }
}
