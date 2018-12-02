package com.example.dream.letter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import java.util.List;

public class one {
    Activity activity;
    protected Button btnaddNote;
    ListView listView;

    public one(Activity activity) {
        this.activity=activity;
        click();
    }

    public void click() {
        btnaddNote = (Button) activity.findViewById(R.id.addNote);
        btnaddNote.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(activity, Activity1.class);
                    activity.startActivity(intent);

            }
        });
    }
    public void show(final List<FindWord> list){
        WordAdapter adapter = new WordAdapter(
                activity, R.layout.layout_item, list);
        listView=(ListView)activity.findViewById(R.id.listNote);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FindWord findWord =list.get(position);

                Intent intent = new Intent(activity, Activity1.class);
                intent.putExtra("name",findWord.getName());
                intent.putExtra("meaning",findWord.getMeaning());
                activity.startActivityForResult(intent,position);
            }
        });
    }

}