package kontenlabsinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.uye.labsinfo.R;
import com.example.uye.labsinfo.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.bumptech.glide.Glide.with;
import static com.example.uye.labsinfo.AppVar.URL_GET_BIODATA;
import static com.example.uye.labsinfo.AppVar.URL_GET_FOTOBIODATA;
import static com.example.uye.labsinfo.R.string.a;

/**
 * Created by LENOVO IP300 on 20/07/2017.
 */

public class bioasisten extends AppCompatActivity {
    String npm;
    int b;
    // Session Manager Class
    SessionManager session;
    private ImageView imghp;
    private TextView txtidasisten, txtnpm, txtnama, txtkelas, txtemail, txtttl, txtjabatan;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kontenbioasisten);
        session = new SessionManager(getApplicationContext());
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();

        // name
        npm = user.get(SessionManager.KEY_NAME).toString();

        // password
        //String password = user.get(SessionManager.KEY_PASSWORD);

        String url = URL_GET_BIODATA + "&npm=" + user.get(SessionManager.KEY_NAME);
        session = new SessionManager(getApplicationContext());

        imghp = (ImageView)findViewById(R.id.imghp);
        txtidasisten = (TextView)findViewById(R.id.txtidasisten);
        txtnpm = (TextView)findViewById(R.id.txtnpm);
        txtnama = (TextView)findViewById(R.id.txtnama);
        txtkelas = (TextView)findViewById(R.id.txtkelas);
        txtemail = (TextView)findViewById(R.id.txtemail);
        txtttl = (TextView)findViewById(R.id.txtttl);
        txtjabatan = (TextView)findViewById(R.id.txtjabatan);

        requestQueue = Volley.newRequestQueue(bioasisten.this);

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("biodataa");
                    for (int a = 0; a < jsonArray.length(); a ++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                            HashMap<String, String> map = new HashMap<String, String>();
                            map.put("id_asisten", json.getString("id_asisten"));
                            map.put("npm", json.getString("npm"));
                            map.put("nama", json.getString("nama"));
                            map.put("kelas", json.getString("kelas"));
                            map.put("email", json.getString("email"));
                            map.put("ttl", json.getString("ttl"));
                            map.put("jabatan", json.getString("jabatan"));
                            map.put("foto", json.getString("foto"));
                            list_data.add(map);

                    }
                    Glide.with(getApplicationContext())
                            .load(URL_GET_FOTOBIODATA + list_data.get(0).get("foto"))
                            .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imghp);
                    txtidasisten.setText(list_data.get(0).get("id_asisten"));
                    txtnpm.setText(list_data.get(0).get("npm"));
                    txtnama.setText(list_data.get(0).get("nama"));
                    txtkelas.setText(list_data.get(0).get("kelas"));
                    txtemail.setText(list_data.get(0).get("email"));
                    txtttl.setText(list_data.get(0).get("ttl"));
                    txtjabatan.setText(list_data.get(0).get("jabatan"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Intent w = new Intent(bioasisten.this, nointernet.class);
                startActivity(w);
                //Toast.makeText(bioasisten.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);
    }
    public void onBackPressed(){
        Intent b = new Intent(bioasisten.this, com.example.uye.labsinfo.iasisten.class);
        startActivity(b);
        finish();
    }
}
