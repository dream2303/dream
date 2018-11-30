package com.example.dream.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_2);
        Second second = new Second(this);

    }


    }

