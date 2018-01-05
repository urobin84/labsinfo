package kontenlabsinfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.uye.labsinfo.AppVar;
import com.example.uye.labsinfo.R;
import com.example.uye.labsinfo.RequestHandler;
import com.example.uye.labsinfo.SessionManager;

import java.util.HashMap;

/**
 * Created by LENOVO IP300 on 20/07/2017.
 */

public class rekap extends AppCompatActivity {
    Button buttonAdd, buttonBack;
    String npm;
    // Session Manager Class
    SessionManager session;
    private Spinner noins, admkls, tugassp, harisp, bulansp, shiftsp, kondisipsp, tglsp, pjshiftsp, kelassp, tahunsp;
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
        setContentView(R.layout.kontenrekap);

        session = new SessionManager(getApplicationContext());
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();

        // name
        npm = user.get(SessionManager.KEY_NAME).toString();

        // password
        //String password = user.get(SessionManager.KEY_PASSWORD);

        buttonAdd = (Button)findViewById(R.id.buttonadd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahdatas();
            }
        });
        buttonBack = (Button)findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(rekap.this, tampilrekaptest.class);
                startActivity(back);
            }
        });
        admkls = (Spinner) findViewById(R.id.spinner5);
        tugassp = (Spinner) findViewById(R.id.spinner6);
        harisp = (Spinner) findViewById(R.id.spinner13);
        bulansp = (Spinner) findViewById(R.id.spinner11);
        shiftsp = (Spinner) findViewById(R.id.spinner15);
        kondisipsp = (Spinner) findViewById(R.id.spinnerkpsp);
        tglsp = (Spinner) findViewById(R.id.spinner12);
        pjshiftsp = (Spinner) findViewById(R.id.spinner16);
        kelassp = (Spinner) findViewById(R.id.spinner14);
        tahunsp = (Spinner) findViewById(R.id.spinner10);

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
        admkls.setAdapter(adapter);
        tugassp.setAdapter(adapterjsp);
        harisp.setAdapter(adapterhsp);
        bulansp.setAdapter(adapterblnsp);
        shiftsp.setAdapter(adaptershfsp);
        kondisipsp.setAdapter(adapterkpsp);
        tglsp.setAdapter(adaptertglsp);
        pjshiftsp.setAdapter(adapterpjssp);
        kelassp.setAdapter(adapterkelaspsp);
        tahunsp.setAdapter(adapterthnspsp);
    }

    public void tambahdatas(){
        final String npms = npm;
        final String klsadm = admkls.getSelectedItem().toString();
        final String tugas = tugassp.getSelectedItem().toString();
        final String hari = harisp.getSelectedItem().toString();
        final String tgl = tglsp.getSelectedItem().toString();
        final String bln = bulansp.getSelectedItem().toString();
        final String thn = tahunsp.getSelectedItem().toString();
        final String shift = shiftsp.getSelectedItem().toString();
        final String kls = kelassp.getSelectedItem().toString();
        final String kondisi = kondisipsp.getSelectedItem().toString();
        final String pj = pjshiftsp.getSelectedItem().toString();


        class tambahdata extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(rekap.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                //Toast.makeText(rekap.this,s,Toast.LENGTH_LONG).show();
                Intent l = new Intent(rekap.this, tampilrekaptest.class);
                startActivity(l);
                finish();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params  = new HashMap<String, String>();
                params.put(AppVar.KEY_ASISTEN_NPM, npms);
                params.put(AppVar.KEY_ASISTEN_KLSADM, klsadm);
                params.put(AppVar.KEY_ASISTEN_TUGAS,tugas);
                params.put(AppVar.KEY_ASISTEN_HARI,hari);
                params.put(AppVar.KEY_ASISTEN_TANGGAL, tgl);
                params.put(AppVar.KEY_ASISTEN_BULAN, bln);
                params.put(AppVar.KEY_ASISTEN_TAHUN, thn);
                params.put(AppVar.KEY_ASISTEN_SHIFT, shift);
                params.put(AppVar.KEY_ASISTEN_KELAS, kls);
                params.put(AppVar.KEY_ASISTEN_KONDISI, kondisi);
                params.put(AppVar.KEY_ASISTEN_PJ, pj);


                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(AppVar.URL_ADD, params);
                return res;
            }
        }
        tambahdata ae = new tambahdata();
        ae.execute();
    }
}