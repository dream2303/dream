package com.example.dream.letter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);
        Two two=new Two(this);
    }
}

