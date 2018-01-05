package kontenlabsinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.uye.labsinfo.R;
import com.example.uye.labsinfo.iasisten;
import com.example.uye.labsinfo.iperaturan;

/**
 * Created by LENOVO IP300 on 20/07/2017.
 */

public class laporanrules extends Activity {
    ImageButton imgla, imglp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kontenlaporanpraktikum);
        addListOnButtonla();
        addListOnButtonlp();
    }
    public void addListOnButtonla(){

        imgla = (ImageButton) findViewById(R.id.imageButtonla);
        imgla.setImageResource(R.drawable.la);
        imgla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(laporanrules.this, picla.class);
                    startActivity(intent);
                finish();
            }
        });
    }
    public void addListOnButtonlp(){

        imglp = (ImageButton) findViewById(R.id.imageButtonlp);
        imglp.setImageResource(R.drawable.lp);
        imglp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(laporanrules.this, piclp.class);
                startActivity(intent);
                finish();
            }
        });
    }public void onBackPressed(){
        Intent b = new Intent(laporanrules.this, com.example.uye.labsinfo.iperaturan.class);
        startActivity(b);
        finish();
    }
    }