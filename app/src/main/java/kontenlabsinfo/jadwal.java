package kontenlabsinfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.MatchResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.uye.labsinfo.R;
import com.example.uye.labsinfo.SessionManager;
import com.example.uye.labsinfo.iasisten;

import static com.example.uye.labsinfo.AppVar.URL_GET_FOTOBIODATA;
import static com.example.uye.labsinfo.R.string.npm;

public class jadwal extends Activity implements OnClickListener {

    rekapdata Jadwalro = new rekapdata();
    TableLayout tabelJadwal;

    ArrayList<Button> buttonView = new ArrayList<Button>();


    String npm, id;
    // Session Manager Class
    SessionManager session;
    JSONArray arrayJadwalr;
    String gambar;
    ArrayList<HashMap<String, String>> list_gj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kontenjadwalasisten);


        session = new SessionManager(getApplicationContext());
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();

        // name
        npm = user.get(SessionManager.KEY_NAME).toString();

        // password
        //String password = user.get(SessionManager.KEY_PASSWORD);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        tabelJadwal = (TableLayout) findViewById(R.id.tbljadwal);

        TableRow barisTabel = new TableRow(this);
        barisTabel.setBackgroundColor(Color.CYAN);

        TextView viewHeaderNoj = new TextView(this);
        TextView viewHeaderNamaj = new TextView(this);
        TextView viewHeaderGambarj = new TextView(this);


        viewHeaderNoj.setText("NO");
        viewHeaderNamaj.setText("NAMA");
        viewHeaderGambarj.setText("GAMBAR");


        viewHeaderNoj.setPadding(5, 1, 5, 1);
        viewHeaderNoj.setGravity(Gravity.CENTER);
        viewHeaderNoj.setWidth(120);
        viewHeaderNamaj.setPadding(5, 1, 5, 1);
        viewHeaderNamaj.setGravity(Gravity.CENTER);
        viewHeaderNamaj.setMinWidth(500);
        viewHeaderNamaj.setMaxWidth(1000);
        viewHeaderGambarj.setPadding(5, 1, 5, 1);
        viewHeaderGambarj.setGravity(Gravity.CENTER);
        viewHeaderGambarj.setWidth(300);

        barisTabel.addView(viewHeaderNoj);
        barisTabel.addView(viewHeaderNamaj);
        barisTabel.addView(viewHeaderGambarj);


        tabelJadwal.addView(barisTabel, new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        list_gj = new ArrayList<HashMap<String, String>>();
        try {
            arrayJadwalr = new JSONArray(Jadwalro.tampilJadwal());

            for (int i = 0; i < arrayJadwalr.length(); i++) {
                JSONObject jsonChildNode = arrayJadwalr.getJSONObject(i);
                String idjadwal = jsonChildNode.optString("id");
                String namajadwal = jsonChildNode.optString("nama");
                gambar = jsonChildNode.optString("gambar");
                String t = Integer.toString(1 + i);

                HashMap<String, String> jap = new HashMap<String, String>();
                jap.put("gambar", jsonChildNode.getString("gambar"));
                list_gj.add(jap);

                System.out.println("ID :" + idjadwal);
                System.out.println("Nama :" + namajadwal);
                System.out.println("Gambar :" + gambar);

                barisTabel = new TableRow(this);

                if (i % 2 == 0) {
                    barisTabel.setBackgroundColor(Color.WHITE);
                }

                TextView viewNo = new TextView(this);
                viewNo.setText(t);
                viewNo.setWidth(120);
                viewNo.setGravity(Gravity.CENTER);
                viewNo.setPadding(5, 1, 5, 5);
                barisTabel.addView(viewNo);

                TextView viewId = new TextView(this);
                viewId.setText(namajadwal);
                viewId.setMinWidth(500);
                viewId.setMaxWidth(1000);
                viewId.setGravity(Gravity.LEFT);
                viewId.setPadding(5, 1, 5, 1);
                barisTabel.addView(viewId);

                buttonView.add(i, new Button(this));
                buttonView.get(i).setId(Integer.parseInt(idjadwal));
                buttonView.get(i).setTag("Lihat");
                buttonView.get(i).setText("Lihat");
                buttonView.get(i).setOnClickListener(this);
                barisTabel.addView(buttonView.get(i));

                tabelJadwal.addView(barisTabel, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Intent w = new Intent(jadwal.this, nointernet.class);
            startActivity(w);
            finish();
        }

    }

    public void onClick(View view) {
        for (int i = 0; i < buttonView.size(); i++) {
    /* jika yang diklik adalah button VIEW */
            if (view.getId() == buttonView.get(i).getId() && view.getTag().toString().trim().equals("Lihat")) {
                Intent t = new Intent(jadwal.this, lihatjadwal.class);
                t.putExtra("val", list_gj.get(i).get("gambar"));
                startActivity(t);
                finish();


            }
        }
    }
    public void onBackPressed(){
        Intent b = new Intent(jadwal.this, com.example.uye.labsinfo.iasisten.class);
        startActivity(b);
        finish();
    }
}