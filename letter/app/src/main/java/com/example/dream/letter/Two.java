package com.example.dream.letter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Two {
    Activity activity;
    protected Button btnsave;
    protected Button btndelete;
    protected Button btncancel;
    protected EditText btntitle ;
    protected EditText btncontent ;
    private Db dbHelper;
    protected String first;
    protected String second;
    private   SQLite sqLite;
    private String meaning;
    private String name;


    public Two(Activity activity) {
        this.activity = activity;
        click();
        sqLite = new SQLite(activity);

    }

    public void click() {
        name = activity.getIntent().getStringExtra("name");
        meaning = activity.getIntent().getStringExtra("meaning");
        Log.i("Tow","name:"+name+"  meaning:"+meaning);
        btntitle = (EditText) activity.findViewById(R.id.title);
        btntitle.setText(name);
        btncontent = (EditText) activity.findViewById(R.id.content);
        btncontent.setText(meaning);
        btnsave = (Button) activity.findViewById(R.id.save);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first = String.valueOf(btntitle.getText());
                second = String.valueOf(btncontent.getText());
                if(name!=null && (!name.equals(String.valueOf(btntitle.getText())) ||  !meaning.equals(String.valueOf(btncontent.getText())))){
                    sqLite.delete(name);
                }

                sqLite.insert(new FindWord(first,second));
                List<FindWord> listTest = sqLite.query();
                Log.i("Tow: ","name:"+listTest.get(0).getName()+"    meaning:"+listTest.get(0).getMeaning());
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
            }
        });
        btndelete = (Button) activity.findViewById(R.id.delete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Tow","delete:"+String.valueOf(btntitle.getText()));
                sqLite.delete(String.valueOf(btntitle.getText()));
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);

            }
        });
        btncancel = (Button) activity.findViewById(R.id.cancel);
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);

            }
        });


    }
}