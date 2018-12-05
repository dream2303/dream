package com.example.dream.letter;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

public class one {
    Activity activity;
    protected Button btnaddNote;
    protected TextView btnfindword;
    protected Button btnfind;
    protected Button btnback;
    protected String word;
    ListView listView;
    protected String find_name;
    protected String find_meaning;
    private List<FindWord> list;
    private List<FindWord> list_1;
SQLite sqLite;

    public one(Activity activity) {
        this.activity = activity;
        sqLite=new SQLite(activity);
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
        btnfindword = (TextView) activity.findViewById(R.id.findwords);
        btnfind = (Button) activity.findViewById(R.id.find);
        btnfind.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                word=String.valueOf(btnfindword.getText());
               list_1= sqLite.find(word);
               if(!list_1.isEmpty()){
                   Log.d("one","find word :"+list_1.get(0).getName());
               }
               else {
                   Log.d("one","list is empty");
               }
                show2(list_1,word);
            }
        });
        btnback = (Button) activity.findViewById(R.id.back);
        btnback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    public void show(final List<FindWord> list) {
        WordAdapter adapter = new WordAdapter(
                activity, R.layout.layout_item, list);
        listView = (ListView) activity.findViewById(R.id.listNote);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FindWord findWord = list.get(position);

                Intent intent = new Intent(activity, Activity1.class);
                intent.putExtra("name", findWord.getName());
                intent.putExtra("meaning", findWord.getMeaning());
                activity.startActivityForResult(intent, position);
            }
        });
    }
    public void show2(final List<FindWord> list, final String word) {
        WordAdapter adapter_1 = new WordAdapter(
                activity, R.layout.layout_item, list);
        listView = (ListView) activity.findViewById(R.id.listNote);
        listView.setAdapter(adapter_1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FindWord findWord = list.get(position);

                Intent intent = new Intent(activity, Activity1.class);
                intent.putExtra("name", findWord.getName());
                intent.putExtra("meaning", findWord.getMeaning());
                activity.startActivityForResult(intent, position);
            }
        });
    }
}