package com.example.uye.labsinfo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;

import kontenlabsinfo.asistenrules;
import kontenlabsinfo.laporanrules;
import kontenlabsinfo.praktikanrules;

import static android.R.id.list;

/**
 * Created by LENOVO IP300 on 17/07/2017.
 */

public class iperaturan extends AppCompatActivity {
    ListView listP;
    Intent intentP;

    // Session Manager Class
    SessionManager sessionP;

    //data dalam bentuk array
    String[] listLabelPeraturan={
            "Praktikum",
            "Laporan",
            "Asisten"};
    Integer[] GbrListPeraturan={
            R.mipmap.praktikum,
            R.mipmap.laporan,
            R.mipmap.asistenrules,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.rules);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("Peraturan");
        setContentView(R.layout.iperaturan);

        // Session class instance
        sessionP = new SessionManager(getApplicationContext());

        iconlistperaturan adapterP = new iconlistperaturan(this, listLabelPeraturan, GbrListPeraturan);
        listP =(ListView) findViewById(R.id.lvPeraturan);
        listP.setAdapter(adapterP);
        //Toast.makeText(getApplicationContext(), "User Login Status: " + sessionP.isLoggedIn(), Toast.LENGTH_LONG).show();

        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        sessionP.checkLogin();

        listP.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int positionP, long id) {

                String PilihitemP = listLabelPeraturan[+positionP];
                //Toast.makeText(getApplicationContext(), PilihitemP, Toast.LENGTH_SHORT).show();
                if (positionP == 0) {
                    intentP = new Intent(getApplicationContext(), praktikanrules.class);
                    startActivity(intentP);
                    finish();
                } else if (positionP == 1) {
                    intentP = new Intent(getApplicationContext(), laporanrules.class);
                    startActivity(intentP);
                    finish();
                } else if (positionP == 2) {
                    intentP = new Intent(getApplicationContext(), asistenrules.class);
                    startActivity(intentP);
                    finish();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(), listLabelPeraturan[positionP], Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
                    t.show();
                }

            }
        });
    }
    public void onBackPressed(){
        Intent b = new Intent(iperaturan.this, Main.class);
        startActivity(b);
        finish();
    }
}
