package kontenlabsinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.uye.labsinfo.R;

/**
 * Created by LENOVO IP300 on 20/07/2017.
 */

public class gabunganadm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kontenpraktikumgabungan);
    }   public void onBackPressed(){
        Intent b = new Intent(gabunganadm.this, com.example.uye.labsinfo.iadministrasi.class);
        startActivity(b);
        finish();
    }
}
