package kontenlabsinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.uye.labsinfo.R;
import com.example.uye.labsinfo.iasisten;
import com.example.uye.labsinfo.touchImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.uye.labsinfo.AppVar.URL_GET_FOTOBIODATA;

/**
 * Created by LENOVO IP300 on 27/09/2017.
 */

public class lihatjadwal extends Activity {
    rekapdata Jadwalg = new rekapdata();
    ArrayList<HashMap<String, String>> list_jadwal;
    JSONArray arrayJadwalg;
    String n;
    TextView a;
    touchImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.lihatjadwal);
        Intent jinten = getIntent();
       n = jinten.getExtras().getString("val");
        //a = (TextView) findViewById(R.id.lja);
        //a.setText(n);

            img = new touchImageView(this);
            Glide.with(getApplicationContext())
                    .load(URL_GET_FOTOBIODATA + n)
                    .crossFade()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(img);
            img.setMaxZoom(4f);
            setContentView(img);
}
    public void onBackPressed(){
        Intent b = new Intent(lihatjadwal.this, jadwal.class);
        startActivity(b);
        finish();
    }
}


