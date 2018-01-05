package com.example.uye.labsinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import kontenlabsinfo.blankoadm;
import kontenlabsinfo.gabunganadm;
import kontenlabsinfo.izinadm;
import kontenlabsinfo.komplainnilaiadm;


/**
 * Created by LENOVO IP300 on 17/07/2017.
 */

public class iadministrasi extends AppCompatActivity {
    ListView listAdm;
    Intent intentAdm;

    // Session Manager Class
    SessionManager sessionAdm;

    //data dalam bentuk array
    String[] listLabelAdministrasi={
            "Izin / Ganti jadwal",
            "Daftar Praktikum Gabungan",
            "Bayar Blanko",
            "Komplain Nilai"};
    Integer[] GbrListAdministrasi={
            R.mipmap.izin,
            R.mipmap.pdfgabungan,
            R.mipmap.blanko,
            R.mipmap.komlinenilai,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.bioasisten);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("Administrasi");
        setContentView(R.layout.iadministrasi);

        // Session class instance
        sessionAdm = new SessionManager(getApplicationContext());

        iconlistperaturan adapterP = new iconlistperaturan(this, listLabelAdministrasi, GbrListAdministrasi);
        listAdm =(ListView) findViewById(R.id.lvAdministrasi);
        listAdm.setAdapter(adapterP);
        //Toast.makeText(getApplicationContext(), "User Login Status: " + sessionAdm.isLoggedIn(), Toast.LENGTH_LONG).show();

        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        sessionAdm.checkLogin();

        listAdm.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int positionAdm, long id) {

                String PilihitemAdm = listLabelAdministrasi[+positionAdm];
                //Toast.makeText(getApplicationContext(), PilihitemAdm, Toast.LENGTH_SHORT).show();
                if (positionAdm == 0) {
                    intentAdm = new Intent(getApplicationContext(), izinadm.class);
                    startActivity(intentAdm);
                    finish();
                } else if (positionAdm == 1) {
                    intentAdm = new Intent(getApplicationContext(), gabunganadm.class);
                    startActivity(intentAdm);
                    finish();
                } else if (positionAdm == 2) {
                    intentAdm = new Intent(getApplicationContext(), blankoadm.class);
                    startActivity(intentAdm);
                    finish();
                }else if (positionAdm == 3) {
                        intentAdm = new Intent(getApplicationContext(), komplainnilaiadm.class);
                        startActivity(intentAdm);
                    finish();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(), listLabelAdministrasi[positionAdm], Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
                    t.show();
                }

            }
        });
    }
    public void onBackPressed(){
        Intent b = new Intent(iadministrasi.this, Main.class);
        startActivity(b);
        finish();
    }
}
