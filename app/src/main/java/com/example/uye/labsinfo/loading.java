package com.example.uye.labsinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import org.json.JSONArray;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by LENOVO IP300 on 15/07/2017.
 */

public class loading extends Activity {
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        sessionManager = new SessionManager(getApplicationContext());
        final int time = 3000;
        Thread  mloading = new Thread(){
            int wait = 0;
            public void run() {
                try{
                    super.run();
                    while(wait < time){
                        sleep(100);
                            wait+=100;
                    }
                }catch (Exception e){
                    System.out.println("Exc = " + e);
                }finally {
                    startActivity(new Intent(loading.this, loginvolley.class));
                    finish();
                }
            }
        };
        mloading.start();
    }
}
