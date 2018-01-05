package kontenlabsinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.uye.labsinfo.R;

/**
 * Created by LENOVO IP300 on 03/10/2017.
 */

public class nointernet extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nointernetres);
    }
    public void onBackPressed(){
        Intent b = new Intent(nointernet.this, com.example.uye.labsinfo.iasisten.class);
        startActivity(b);
        finish();
    }
}