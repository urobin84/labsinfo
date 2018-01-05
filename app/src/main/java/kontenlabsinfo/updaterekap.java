package kontenlabsinfo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.uye.labsinfo.AppVar;
import com.example.uye.labsinfo.R;
import com.example.uye.labsinfo.RequestHandler;
import com.example.uye.labsinfo.SessionManager;
import com.example.uye.labsinfo.touchImageView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.uye.labsinfo.AppVar.URL_GET_FOTOBIODATA;

/**
 * Created by LENOVO IP300 on 03/10/2017.
 */

public class updaterekap extends AppCompatActivity {
    Button buttonUpdate, buttonBack;
    String npm, idasisten;
    SessionManager session;
    private Spinner testsp, uadmkls, utugassp, uharisp, ubulansp, ushiftsp, ukondisipsp, utglsp, upjshiftsp, ukelassp, utahunsp;
    //array spinner klsadm
    private String[] klsadm = {
            "Kampus E Dasar",
            "Kampus E M/L",
            "Kampus H",
            "Kalimalang",
            "Karawaci",
            "Cengkareng",
    };
    //array spinner jabatan
    private String[] jabatan = {
            "PJ Shift",
            "Ketua",
            "Tutor",
            "Asisten",
    };
    //array spinner hari
    private String[] hari = {
            "Senin",
            "Selasa",
            "Rabu",
            "Kamin",
            "Jum'at",
            "Sabtu",
            "Minggu",
    };
    //array spinner bulan
    private String[] Bulan = {
            "Januari",
            "Februari",
            "Maret",
            "April",
            "Mei",
            "Juni",
            "Juli",
            "Agustus",
            "September",
            "Oktober",
            "November",
            "Desember",
    };
    //array spinner shift
    private String[] shift = {
            "shift 1",
            "shift 2",
            "shift 3",
            "shift 4",
            "shift 5",
    };
    //array spinner kondisip
    private String[] kondisip = {
            "Normal",
            "2F",
            "Bonus",
    };
    //array spinner tglp
    private String[] tglp = {
            "1","2","3","4","5","6","7","8","9","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30",
            "31",
    };
    //array spinner pjshift
    private String[] pjshiftp = {
            "Asti",
            "Della",
            "Robin",
    };
    //array spinner kelas
    private String[] kelasp = {
            "1KA",
            "2KA",
            "3KA",
            "4KA",
    };
    //array spinner tahun
    private String[] tahunp = {
            "2016",
            "2017",
            "2018",
            "2019",
            "2020",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updaterekap);

        buttonUpdate = (Button)findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedatas();
            }
        });
        buttonBack = (Button)findViewById(R.id.buttonBackr);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(updaterekap.this, tampilrekaptest.class);
                startActivity(back);
            }
        });
        Intent intent = getIntent();
        idasisten = intent.getStringExtra("uy");


        session = new SessionManager(getApplicationContext());
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();
        // name
        npm = user.get(SessionManager.KEY_NAME).toString();

        uadmkls = (Spinner) findViewById(R.id.admsp);
        utugassp = (Spinner) findViewById(R.id.tgssp);
        uharisp = (Spinner) findViewById(R.id.hrisp);
        ubulansp = (Spinner) findViewById(R.id.blnsp);
        ushiftsp = (Spinner) findViewById(R.id.shftsp);
        ukondisipsp = (Spinner) findViewById(R.id.konsp);
        utglsp = (Spinner) findViewById(R.id.tglsp);
        upjshiftsp = (Spinner) findViewById(R.id.pjsp);
        ukelassp = (Spinner) findViewById(R.id.klssp);
        utahunsp = (Spinner) findViewById(R.id.thsp);

        // inisialiasi Array Adapter dengan memasukkan string array di atas
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, klsadm);
        final ArrayAdapter<String> adapterjsp = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, jabatan);
        final ArrayAdapter<String> adapterhsp = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, hari);
        final ArrayAdapter<String> adapterblnsp = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Bulan);
        final ArrayAdapter<String> adaptershfsp = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, shift);
        final ArrayAdapter<String> adapterkpsp = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, kondisip);
        final ArrayAdapter<String> adaptertglsp = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, tglp);
        final ArrayAdapter<String> adapterpjssp = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, pjshiftp);
        final ArrayAdapter<String> adapterkelaspsp = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, kelasp);
        final ArrayAdapter<String> adapterthnspsp = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, tahunp);

        // mengeset Array Adapter tersebut ke Spinner
        uadmkls.setAdapter(adapter);
        utugassp.setAdapter(adapterjsp);
        uharisp.setAdapter(adapterhsp);
        ubulansp.setAdapter(adapterblnsp);
        ushiftsp.setAdapter(adaptershfsp);
        ukondisipsp.setAdapter(adapterkpsp);
        utglsp.setAdapter(adaptertglsp);
        upjshiftsp.setAdapter(adapterpjssp);
        ukelassp.setAdapter(adapterkelaspsp);
        utahunsp.setAdapter(adapterthnspsp);

    }
    public void updatedatas(){
        final String id = idasisten;
        final String npms = npm;
        final String klsadm = uadmkls.getSelectedItem().toString();
        final String tugas = utugassp.getSelectedItem().toString();
        final String hari = uharisp.getSelectedItem().toString();
        final String tgl = utglsp.getSelectedItem().toString();
        final String bln = ubulansp.getSelectedItem().toString();
        final String thn = utahunsp.getSelectedItem().toString();
        final String shift = ushiftsp.getSelectedItem().toString();
        final String kls = ukelassp.getSelectedItem().toString();
        final String kondisi = ukondisipsp.getSelectedItem().toString();
        final String pj = upjshiftsp.getSelectedItem().toString();


        class updatedata extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(updaterekap.this,"UPDATING...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                //Toast.makeText(rekap.this,s,Toast.LENGTH_LONG).show();
                Intent l = new Intent(updaterekap.this, tampilrekaptest.class);
                startActivity(l);
                finish();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params  = new HashMap<String, String>();
                params.put(AppVar.KEY_ID, id);
                params.put(AppVar.KEY_ASISTEN_NPM, npms);
                params.put(AppVar.KEY_ASISTEN_KLSADM, klsadm);
                params.put(AppVar.KEY_ASISTEN_TUGAS, tugas);
                params.put(AppVar.KEY_ASISTEN_HARI, hari);
                params.put(AppVar.KEY_ASISTEN_TANGGAL, tgl);
                params.put(AppVar.KEY_ASISTEN_BULAN, bln);
                params.put(AppVar.KEY_ASISTEN_TAHUN, thn);
                params.put(AppVar.KEY_ASISTEN_SHIFT, shift);
                params.put(AppVar.KEY_ASISTEN_KELAS, kls);
                params.put(AppVar.KEY_ASISTEN_KONDISI, kondisi);
                params.put(AppVar.KEY_ASISTEN_PJ, pj);


                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(AppVar.URL_UPDATE_REKAP, params);
                return res;
            }
        }
        updatedata ae = new updatedata();
        ae.execute();
    }
    public void onBackPressed(){
        Intent b = new Intent(updaterekap.this, tampilrekaptest.class);
        startActivity(b);
        finish();
    }
}
