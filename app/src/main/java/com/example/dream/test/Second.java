package com.example.dream.test;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second extends Standard {
    Button btnsin;
    Button btncos;
    Button btntan;
    Button btnln;

    public Second(Activity activity) {
        super(activity);
    }

    @Override
    protected void click() {
        super.click();
        btnsin = (Button) activity.findViewById(R.id.sin);
        final TextView txtResult = (TextView) activity.findViewById(R.id.MYTextView);
        btnsin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="S";
                txtResult.setText(answer);
            }
        });


        btncos = (Button) activity.findViewById(R.id.cos);
        btncos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="C";
                txtResult.setText(answer);
            }
        });

        btntan = (Button) activity.findViewById(R.id.tan);
        btntan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="T";
                txtResult.setText(answer);
            }
        });

        btnln= (Button) activity.findViewById(R.id.ln);
        btnln.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="L";
                txtResult.setText(answer);
            }
        });
    }

    @Override
    protected void change() {
        Intent intent=new Intent(activity,MainActivity.class);
        activity.startActivity(intent);
    }
}