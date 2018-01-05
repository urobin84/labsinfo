package kontenlabsinfo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.uye.labsinfo.R;

/**
 * Created by LENOVO IP300 on 20/07/2017.
 */

public class blankoadm extends Activity {
    ImageButton imgbtn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kontenbayarblanko);
        addListOnButton();
    }
    public void addListOnButton(){

        imgbtn = (ImageButton) findViewById(R.id.fblankokb);
        imgbtn.setImageResource(R.drawable.fblanko);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(blankoadm.this, picblanko.class);
                startActivity(intent);
                finish();
            }
        });
    }public void onBackPressed(){
        Intent b = new Intent(blankoadm.this, com.example.uye.labsinfo.iadministrasi.class);
        startActivity(b);
        finish();
    }
}