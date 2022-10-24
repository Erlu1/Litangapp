package com.example.applicationwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myThread.start();
    }
    Thread myThread=new Thread(){
        public void run(){
            try {
                sleep(3000);
                Intent i=new Intent(MainActivity.this, MainloginActivity.class);
                startActivity(i);
                finish();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };
}