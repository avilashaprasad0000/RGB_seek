package com.example.rgb_seek;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.*;
import android.widget.*;
import java.lang.*;

public class MainActivity extends AppCompatActivity {
    SeekBar s1,s2,s3;
    TextView tv3,tv4,tv5;
    ConstraintLayout c;
    public void drag()
    {

        int R,G,B;
        R=s1.getProgress();
        G=s2.getProgress();
        B=s3.getProgress();
        c.setBackgroundColor(Color.rgb(R, G, B));
        //String hexcolor = String.format("#%02x%02x%02x", R, G, B);
        //Alternative which I can use
                /*
                cl.setBackgroundColor(0xff000000+R*0x10000+G*0x100+B);*/

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1=findViewById(R.id.sb1);
        s2=findViewById(R.id.sb2);
        s3=findViewById(R.id.sb3);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        c= findViewById(R.id.c_layout);
        s1.setMax(255);
        s2.setMax(255);
        s3.setMax(255);
        s1.setProgress(200);
        s2.setProgress(150);
        s3.setProgress(100);
        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int p1;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                p1=progress;
                tv3.setText(p1+"");
                drag();
            }
            public void onStartTrackingTouch(SeekBar seekBar){
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"R = "+p1,Toast.LENGTH_SHORT).show();
                tv3.setText(p1+"");
            }

        });
        s2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int p2;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                p2=progress;
                tv4.setText(p2+ "");
                drag();
            }
            public void onStartTrackingTouch(SeekBar seekBar){
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"G = "+p2,Toast.LENGTH_SHORT).show();
                tv4.setText(p2+ "");

            }
        });
        s3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int p3;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                p3 = progress;
                tv5.setText(p3+"");
                drag();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "B = " + p3, Toast.LENGTH_SHORT).show();
                tv5.setText(p3+ "");

            }
        });

    }

    }

