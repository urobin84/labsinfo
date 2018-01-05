package kontenlabsinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.uye.labsinfo.R;

/**
 * Created by LENOVO IP300 on 20/07/2017.
 */

public class komplainnilaiadm extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kontentkomnilai);
    }   public void onBackPressed(){
        Intent b = new Intent(komplainnilaiadm.this, com.example.uye.labsinfo.iadministrasi.class);
        startActivity(b);
        finish();
    }
}
