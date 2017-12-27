package com.cepstrum.vikas.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.media.AsyncPlayer;

import java.util.List;



public class MainActivity extends AppCompatActivity {
    public static final String TAG = "com.cepstrum.Intenttest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, MyService.class));


        ImageView iv;
        iv= (ImageView) findViewById(R.id.search);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });




    }

    @Override
    protected  void onResume() {
        super.onResume();

    }


    @Override
    protected void onDestroy(){

        Log.d(TAG,"Service Should Stop.");
        stopService(new Intent(this, MyService.class));
        super.onDestroy();
    }
}
