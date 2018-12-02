package com.example.dream.test;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Standard {
    Activity activity;
   protected Button btnAC;
    protected  Button btnDel;
    protected Button btnfen;
    protected Button btnchu;
    protected Button btnseven;
    protected Button btneight;
    protected Button btnnine;
    protected Button btncheng;
    protected Button btnfour;
    protected Button btnfive;
    protected  Button btnsix;
    protected  Button btnjian;
    protected  Button btnone;
    protected  Button btntwo;
    protected   Button btnthree;
    protected  Button btnjia;
    protected  Button btnzero;
    protected  Button btnchange1;
    protected   Button btndian;
    protected   Button btndeng;
    protected Double res;

protected String answer;

    public Standard() {
    }

    public Standard(Activity activity) {
        this.activity = activity;
        click();
        Log.i("Standard",""+activity);
        answer="";
    }

    protected void click() {
        btnAC = (Button) activity.findViewById(R.id.AC);
        final TextView txtResult = (TextView) activity.findViewById(R.id.MYTextView);
        btnAC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
         answer="";
                txtResult.setText("");
            }
        });

        btnDel = (Button) activity.findViewById(R.id.Del);
        btnDel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!answer.equals("")){
                    answer.substring(0,answer.length()-1);
                    txtResult.setText(answer);
                }
            }
        });

        btnfen = (Button) activity.findViewById(R.id.fen);
        btnfen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="%";
                txtResult.setText(answer);
            }
        });

        btnchu = (Button) activity.findViewById(R.id.chu);
        btnchu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="/";
                txtResult.setText(answer);
            }
        });

        btnseven = (Button) activity.findViewById(R.id.seven);
        btnseven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="7";
                txtResult.setText(answer);
            }
        });

        btneight = (Button) activity.findViewById(R.id.eigth);
        btneight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="8";
                txtResult.setText(answer);
            }
        });

        btnnine = (Button) activity.findViewById(R.id.nine);
        btnnine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="9";
                txtResult.setText(answer);
            }
        });

        btncheng = (Button) activity.findViewById(R.id.cheng);
        btncheng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="*";
                txtResult.setText(answer);
            }
        });

        btnfour = (Button) activity.findViewById(R.id.four);
        btnfour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="4";
                txtResult.setText(answer);
            }
        });

        btnfive = (Button) activity.findViewById(R.id.five);
        btnfive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="5";
                txtResult.setText(answer);
            }
        });

        btnsix = (Button) activity.findViewById(R.id.six);
        btnsix.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="6";
                txtResult.setText(answer);
            }
        });

        btnjian = (Button) activity.findViewById(R.id.jian);
        btnjian.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="-";
                txtResult.setText(answer);
            }
        });

        btnone = (Button) activity.findViewById(R.id.one);
        btnone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="1";
                txtResult.setText(answer);
            }
        });

        btntwo = (Button) activity.findViewById(R.id.two);
        btntwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="2";
                txtResult.setText(answer);
            }
        });

        btnthree = (Button) activity.findViewById(R.id.three);
        btnthree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="3";
                txtResult.setText(answer);
            }
        });

        btnjia = (Button) activity.findViewById(R.id.jia);
        btnjia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="+";
                txtResult.setText(answer);
            }
        });

        btnchange1 = (Button) activity.findViewById(R.id.change1);
        btnchange1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                change();
            }
        });


        btnzero = (Button) activity.findViewById(R.id.zero);
        btnzero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+="0";
                txtResult.setText(answer);
            }
        });

        btndian = (Button) activity.findViewById(R.id.dian);
        btndian.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answer+=".";
                txtResult.setText(answer);
            }
        });

        btndeng = (Button) activity.findViewById(R.id.deng);
        btndeng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity","answer:"+answer);
                res = EvaluateExpression.evaluateExpression(answer);
                txtResult.setText(txtResult.getText()+"="+res);
            }
        });
    }

    protected void change() {
        Intent intent = new Intent(activity, Activity1.class);
        activity.startActivity(intent);
    }
}
