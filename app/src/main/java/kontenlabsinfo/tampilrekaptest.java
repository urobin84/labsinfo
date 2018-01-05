package kontenlabsinfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


import com.example.uye.labsinfo.R;
import com.example.uye.labsinfo.SessionManager;
import com.example.uye.labsinfo.iasisten;

import static com.example.uye.labsinfo.R.string.npm;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class tampilrekaptest extends AppCompatActivity implements OnClickListener {

        rekapdata Rekapro = new rekapdata();
        TableLayout tabelRekap;
        Integer i,d;

        Button buttonTambahRekap;
        ArrayList<Button> buttonEdit = new ArrayList<Button>();
        ArrayList<Button> buttonDelete = new ArrayList<Button>();
        ArrayList<TextView>idarray = new ArrayList<TextView>();

    ArrayList<HashMap<String, String>> list_ur;

    String npm;
    JSONArray arrayPersonal;
    // Session Manager Class
    SessionManager session;
        JSONArray arrayRekapr;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilrekap);

    session = new SessionManager(getApplicationContext());
    session.checkLogin();
    HashMap<String, String> user = session.getUserDetails();

    // name
    npm = user.get(SessionManager.KEY_NAME).toString();


    // password
    //String password = user.get(SessionManager.KEY_PASSWORD);

        if(android.os.Build.VERSION.SDK_INT>9)
        {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
        .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        }

        tabelRekap = (TableLayout) findViewById(R.id.tableRekap);
        buttonTambahRekap = (Button) findViewById(R.id.buttonTambahBiodata);
        buttonTambahRekap.setOnClickListener(this);

        TableRow barisTabel = new TableRow(this);
        barisTabel.setBackgroundColor(Color.CYAN);

        TextView viewHeaderNo = new TextView(this);
        TextView viewHeaderKlsadm = new TextView(this);
        TextView viewHeaderTugas = new TextView(this);
        TextView viewHeaderHari = new TextView(this);
        TextView viewHeaderTgl = new TextView(this);
        TextView viewHeaderBln = new TextView(this);
        TextView viewHeaderThn = new TextView(this);
        TextView viewHeaderShift = new TextView(this);
        TextView viewHeaderKelas = new TextView(this);
        TextView viewHeaderKondisi = new TextView(this);
        TextView viewHeaderPj = new TextView(this);
        TextView viewHeaderAction = new TextView(this);

        viewHeaderNo.setText("NO");
        viewHeaderKlsadm.setText("ADMINISTRASI");
        viewHeaderTugas.setText("TUGAS");
        viewHeaderHari.setText("HARI");
        viewHeaderTgl.setText("TANGGAL");
        viewHeaderBln.setText("BULAN");
        viewHeaderThn.setText("TAHUN");
        viewHeaderShift.setText("SHIFT");
        viewHeaderKelas.setText("KELAS");
        viewHeaderKondisi.setText("KONDISI");
        viewHeaderPj.setText("PJ");
        viewHeaderAction.setText("ACTION");


        viewHeaderNo.setPadding(5, 1, 5, 1);
        viewHeaderNo.setGravity(Gravity.CENTER);
        viewHeaderNo.setWidth(120);
        viewHeaderKlsadm.setPadding(5, 1, 5, 1);
    viewHeaderKlsadm.setGravity(Gravity.CENTER);
    viewHeaderKlsadm.setWidth(450);
        viewHeaderTugas.setPadding(5, 1, 5, 1);
    viewHeaderTugas.setGravity(Gravity.CENTER);
    viewHeaderTugas.setWidth(200);
        viewHeaderHari.setPadding(5, 1, 5, 1);
    viewHeaderHari.setGravity(Gravity.CENTER);
    viewHeaderHari.setWidth(200);
        viewHeaderTgl.setPadding(5, 1, 5, 1);
    viewHeaderTgl.setGravity(Gravity.CENTER);
    viewHeaderTgl.setWidth(270);
        viewHeaderBln.setPadding(5, 1, 5, 1);
    viewHeaderBln.setGravity(Gravity.CENTER);
    viewHeaderBln.setWidth(200);
        viewHeaderThn.setPadding(5, 1, 5, 1);
    viewHeaderThn.setGravity(Gravity.CENTER);
    viewHeaderThn.setWidth(200);
        viewHeaderShift.setPadding(5, 1, 5, 1);
    viewHeaderShift.setGravity(Gravity.CENTER);
    viewHeaderShift.setWidth(200);
        viewHeaderKelas.setPadding(5, 1, 5, 1);
    viewHeaderKelas.setGravity(Gravity.CENTER);
    viewHeaderKelas.setWidth(200);
        viewHeaderKondisi.setPadding(5, 1, 5, 1);
    viewHeaderKondisi.setGravity(Gravity.CENTER);
    viewHeaderKondisi.setWidth(250);
        viewHeaderPj.setPadding(5, 1, 5, 1);
    viewHeaderPj.setGravity(Gravity.CENTER);
    viewHeaderPj.setWidth(200);
        viewHeaderAction.setPadding(5, 1, 5, 1);
    viewHeaderAction.setGravity(Gravity.CENTER);

        barisTabel.addView(viewHeaderNo);
        barisTabel.addView(viewHeaderKlsadm);
        barisTabel.addView(viewHeaderTugas);
        barisTabel.addView(viewHeaderHari);
        barisTabel.addView(viewHeaderTgl);
        barisTabel.addView(viewHeaderBln);
        barisTabel.addView(viewHeaderThn);
        barisTabel.addView(viewHeaderShift);
        barisTabel.addView(viewHeaderKelas);
        barisTabel.addView(viewHeaderKondisi);
        barisTabel.addView(viewHeaderPj);
        barisTabel.addView(viewHeaderAction);

        tabelRekap.addView(barisTabel, new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
        LayoutParams.WRAP_CONTENT));

        try {
        arrayRekapr = new JSONArray(Rekapro.tampilRekap(npm));

        for (i = 0; i < arrayRekapr.length(); i++) {
        JSONObject jsonChildNode = arrayRekapr.getJSONObject(i);
            String klsadm = jsonChildNode.optString("admkelas");
            String tugas = jsonChildNode.optString("tugas");
            String hari = jsonChildNode.optString("hari");
            String tgl = jsonChildNode.optString("tanggal");
            String bln = jsonChildNode.optString("bln");
            String thn = jsonChildNode.optString("thn");
            String shift = jsonChildNode.optString("shift");
            String kls = jsonChildNode.optString("kelas");
            String kondisi = jsonChildNode.optString("kondisi");
            String pj = jsonChildNode.optString("pj_rekap");
            String id = jsonChildNode.optString("id");
            String t = Integer.toString(1+i);

            System.out.println("KlsAdm :" + klsadm);
            System.out.println("Tugas :" + tugas);
            System.out.println("Hari :" + hari);
            System.out.println("Tanggal :" + tgl);
            System.out.println("Bulan :" + bln);
            System.out.println("Tahun :" + thn);
            System.out.println("Shift :" + shift);
            System.out.println("Kelas :" + kls);
            System.out.println("Kondisi :" + kondisi);
            System.out.println("Pj :" + pj);
            System.out.println("ID :" + id);

        barisTabel = new TableRow(this);

        if (i % 2 == 0) {
        barisTabel.setBackgroundColor(Color.WHITE);
        }

            TextView viewNo = new TextView(this);
            viewNo.setText(t);
            viewNo.setWidth(120);
            viewNo.setGravity(Gravity.RIGHT);
            viewNo.setPadding(5, 1, 5, 5);
            barisTabel.addView(viewNo);

            TextView viewKlsadm = new TextView(this);
            viewKlsadm.setText(klsadm);
            viewKlsadm.setWidth(450);
            viewKlsadm.setGravity(Gravity.LEFT);
            viewKlsadm.setPadding(5, 1, 5, 1);
            barisTabel.addView(viewKlsadm);

            TextView viewTugas = new TextView(this);
            viewTugas.setText(tugas);
            viewTugas.setWidth(200);
            viewTugas.setGravity(Gravity.LEFT);
            viewTugas.setPadding(5, 1, 5, 1);
            barisTabel.addView(viewTugas);

            TextView viewHari = new TextView(this);
            viewHari.setText(hari);
            viewHari.setWidth(200);
            viewHari.setGravity(Gravity.LEFT);
            viewHari.setPadding(5, 1, 5, 1);
            barisTabel.addView(viewHari);

            TextView viewTgl = new TextView(this);
            viewTgl.setText(tgl);
            viewTgl.setWidth(270);
            viewTgl.setGravity(Gravity.CENTER);
            viewTgl.setPadding(5, 1, 5, 1);
            barisTabel.addView(viewTgl);

            TextView viewBln = new TextView(this);
            viewBln.setText(bln);
            viewBln.setWidth(300);
            viewBln.setGravity(Gravity.LEFT);
            viewBln.setPadding(5, 1, 5, 1);
            barisTabel.addView(viewBln);

            TextView viewThn = new TextView(this);
            viewThn.setText(thn);
            viewThn.setWidth(200);
            viewThn.setGravity(Gravity.CENTER);
            viewThn.setPadding(5, 1, 5, 1);
            barisTabel.addView(viewThn);

            TextView viewShift = new TextView(this);
            viewShift.setText(shift);
            viewShift.setWidth(200);
            viewShift.setGravity(Gravity.CENTER);
            viewShift.setPadding(5, 1, 5, 1);
            barisTabel.addView(viewShift);

            TextView viewKls = new TextView(this);
            viewKls.setText(kls);
            viewKls.setWidth(200);
            viewKls.setGravity(Gravity.LEFT);
            viewKls.setPadding(5, 1, 5, 1);
            barisTabel.addView(viewKls);

            TextView viewKondisi = new TextView(this);
            viewKondisi.setText(kondisi);
            viewKondisi.setWidth(250);
            viewKondisi.setGravity(Gravity.LEFT);
            viewKondisi.setPadding(5, 1, 5, 1);
            barisTabel.addView(viewKondisi);

            TextView viewPj = new TextView(this);
            viewPj.setText(pj);
            viewPj.setWidth(200);
            viewPj.setGravity(Gravity.LEFT);
            viewPj.setPadding(5, 1, 5, 1);
            barisTabel.addView(viewPj);

            idarray.add(i, new TextView(this));
            idarray.get(i).setId(parseInt(id));
            idarray.get(i).setText(id);


            buttonEdit.add(i, new Button(this));
            buttonEdit.get(i).setId(parseInt(id));
            buttonEdit.get(i).setTag("Edit");
            buttonEdit.get(i).setText("Edit");
            buttonEdit.get(i).setOnClickListener(this);
            barisTabel.addView(buttonEdit.get(i));

            buttonDelete.add(i, new Button(this));
            buttonDelete.get(i).setId(parseInt(id));
            buttonDelete.get(i).setTag("Delete");
            buttonDelete.get(i).setText("Delete");
            buttonDelete.get(i).setOnClickListener(this);
            barisTabel.addView(buttonDelete.get(i));

        tabelRekap.addView(barisTabel, new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
        LayoutParams.WRAP_CONTENT));
        }
        } catch (JSONException e) {
        e.printStackTrace();
            Intent w = new Intent(tampilrekaptest.this, nointernet.class);
            startActivity(w);
            finish();
        }
        }

public void onClick(View view) {

        if (view.getId() == R.id.buttonTambahBiodata) {
        // Toast.makeText(MainActivity.this, "Button Tambah Data",
        // Toast.LENGTH_SHORT).show();

            Intent t = new Intent(tampilrekaptest.this, rekap.class);
            startActivity(t);
            finish();
        } else {
   /*
    * Melakukan pengecekan pada data array, agar sesuai dengan index
    * masing-masing button
    */
            for (int i = 0; i < buttonEdit.size(); i++) {


    /* jika yang diklik adalah button edit */
                if (view.getId() == buttonEdit.get(i).getId() && view.getTag().toString().trim().equals("Edit")) {
                    Intent u = new Intent(tampilrekaptest.this, updaterekap.class);
                    u.putExtra("uy", idarray.get(i).getText());
                    startActivity(u);
                    finish();

                } /* jika yang diklik adalah button delete */ else if (view.getId() == buttonDelete.get(i).getId() && view.getTag().toString().trim().equals("Delete")) {
                    // Toast.makeText(MainActivity.this, "Delete : " +
                    // buttonDelete.get(i).getId(), Toast.LENGTH_SHORT).show();
                    d = buttonDelete.get(i).getId();
                    showDialog();
                }
            }

        }
}
    public void deleteRekap(int id) {
        Rekapro.deleteRekap(id);

  /* restart acrtivity */
        finish();
        startActivity(getIntent());

    }


    public void onBackPressed(){
        Intent b = new Intent(tampilrekaptest.this, iasisten.class);
        startActivity(b);
        finish();
    }
    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Yakin Ingin menghapus baris rekap?");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk menghapus!")
                .setIcon(R.drawable.warning)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        deleteRekap(d);
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }
}