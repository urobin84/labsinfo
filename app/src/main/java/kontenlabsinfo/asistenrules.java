package kontenlabsinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.uye.labsinfo.R;

/**
 * Created by LENOVO IP300 on 20/07/2017.
 */

public class asistenrules extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kontenasistenrules);
    }
    public void onBackPressed(){
        Intent b = new Intent(asistenrules.this, com.example.uye.labsinfo.iperaturan.class);
        startActivity(b);
        finish();
    }
}

