package com.example.dream.letter;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Db extends SQLiteOpenHelper {
    private final static String SQL_CREATE_DATABASE ="CREATE TABLE words (name TEXT,meaning TEXT)";

    private Context mcontext;

    public Db(Context context,String name,SQLiteDatabase.CursorFactory factory,int version) {
        super(context, name, factory, version);
        mcontext=context;
    }

    public void onCreate(SQLiteDatabase db) {        //创建数据库
        db.execSQL(SQL_CREATE_DATABASE);
        Toast.makeText(mcontext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
