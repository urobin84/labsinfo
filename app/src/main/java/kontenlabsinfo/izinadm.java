package kontenlabsinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.uye.labsinfo.R;
import com.example.uye.labsinfo.touchImageView;

/**
 * Created by LENOVO IP300 on 20/07/2017.
 */

public class izinadm extends Activity {
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kontenizin);
        addListOnButton();
    }
    public void addListOnButton(){

        imageButton = (ImageButton) findViewById(R.id.fpjadwal);
        imageButton.setImageResource(R.drawable.pindahjadwalform);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(izinadm.this, picfipjadwal.class);
                startActivity(intent);
                finish();
            }
        });
    }public void onBackPressed(){
        Intent b = new Intent(izinadm.this, com.example.uye.labsinfo.iadministrasi.class);
        startActivity(b);
        finish();
    }
}