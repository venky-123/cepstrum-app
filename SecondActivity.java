package com.cepstrum.vikas.myproject;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.Manifest;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;


public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda_view);


        String filename = "data";
        StringBuilder finalstring = new StringBuilder();
        File file = new File(getFilesDir(), filename);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            String oneLine;

            while ((oneLine = bufferedReader.readLine()) != null) {
                finalstring.append(oneLine);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        TextView textView = (TextView) findViewById(R.id.rData);
        textView.setText(finalstring);

        LinearLayout avMain = (LinearLayout) findViewById(R.id.av_main);
        // Toast.makeText(this,String.valueOf(avMain.getWeightSum()),Toast.LENGTH_SHORT).show();


        AvEventView avView2 = new AvEventView(this, "2", "EE 200", "9:00 - 10:00", "2002", "Amitabh C", "VLSI", "0-0-3-3", "01-08-2017", "1");
        avMain.addView(avView2.getView());
        AvEventView avView3 = new AvEventView(this, "3", "EE 220", "10:00 - 11:00", "2002", "Srinivas", "Control Systems", "3-0-0-6", "01-08-2017", "2");
        avMain.addView(avView3.getView());
        AvEventView avView4 = new AvEventView(this, "4", "EE 201", "11:00 - 12:00", "2002", "Kalpana Dutta", "Digital Signal Processing", "3-0-0-6", "01-08-2017", "3");
        avMain.addView(avView4.getView());
        AvEventView avView5 = new AvEventView(this, "5", "EE 280", "2:00 - 5:00", "Simulation Lab", "C.Amitabh", "VLSI lab", "0-0-3-3", "01-08-2017", "4");
        avMain.addView(avView5.getView());


    }
}