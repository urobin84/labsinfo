package com.example.uye.labsinfo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import kontenlabsinfo.bioasisten;
import kontenlabsinfo.jadwal;
import kontenlabsinfo.rekap;
import kontenlabsinfo.tampilrekaptest;

/**
 * Created by LENOVO IP300 on 17/07/2017.
 */

public class iasisten extends AppCompatActivity {
    ListView listAs;
    Intent intentAs;

    // Session Manager Class
    SessionManager sessionAs;

    //data dalam bentuk array
    String[] listLabelAsisten={
            "Biodata",
            "Rekap Asisten",
            "Jadwal"
    };
    Integer[] GbrListAsisten={
            R.mipmap.bioa,
            R.mipmap.rekapa,
            R.mipmap.jadwal,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.asistenhome);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("Asisten");
        setContentView(R.layout.iasisten);

        // Session class instance
        sessionAs = new SessionManager(getApplicationContext());

        iconlistperaturan adapterAs = new iconlistperaturan(this, listLabelAsisten, GbrListAsisten);
        listAs =(ListView) findViewById(R.id.lvAsisten);
        listAs.setAdapter(adapterAs);
        //Toast.makeText(getApplicationContext(), "User Login Status: " + sessionAs.isLoggedIn(), Toast.LENGTH_LONG).show();

        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        sessionAs.checkLogin();

        listAs.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int positionAs, long id) {

                String PilihitemAs = listLabelAsisten[+positionAs];
                //Toast.makeText(getApplicationContext(), PilihitemAs, Toast.LENGTH_SHORT).show();
                if (positionAs == 0) {
                    intentAs = new Intent(getApplicationContext(), bioasisten.class);
                    startActivity(intentAs);
                    finish();
                } else if (positionAs == 1) {
                    intentAs = new Intent(getApplicationContext(), tampilrekaptest.class);
                    finish();
                    startActivity(intentAs);

                } else if (positionAs == 2) {
                    intentAs = new Intent(getApplicationContext(), jadwal.class);
                    startActivity(intentAs);
                    finish();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(), listLabelAsisten[positionAs], Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
                    t.show();
                }

            }
        });
    }
    public void onBackPressed(){
        Intent b = new Intent(iasisten.this, Main.class);
        startActivity(b);
        finish();
    }
}
