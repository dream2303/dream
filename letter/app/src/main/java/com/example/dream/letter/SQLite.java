package com.example.dream.letter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class SQLite {

    private SQLiteDatabase db;
    public static final String DATABASE_NAME = "words.db";

    public SQLite(Context context) {
        db = new Db(context, DATABASE_NAME, null, 1).getWritableDatabase();
    }

    public void insert(FindWord findWord) {
        ContentValues values = new ContentValues();
        values.put("name",findWord.getName());
        values.put("meaning",findWord.getMeaning());
        db.insert("words",null,values);

    }


    public void delete(String name) {
        db.delete("words","name=?",new String[]{name});
    }

    public List<FindWord> query() {
        Cursor cursor = db.query("words", null, null, null, null, null, null);
        List<FindWord> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String meaning = cursor.getString(cursor.getColumnIndex("meaning"));
                FindWord findWord = new FindWord();
                findWord.setName(name);
                findWord.setMeaning(meaning);
                list.add(findWord);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

}