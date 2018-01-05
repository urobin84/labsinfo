package kontenlabsinfo;

import android.app.Activity;
import android.os.Bundle;

import com.example.uye.labsinfo.R;
import com.example.uye.labsinfo.touchImageView;

/**
 * Created by LENOVO IP300 on 25/07/2017.
 */

public class piclp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.test);

        touchImageView img = new touchImageView(this);
        img.setImageResource(R.drawable.lp);
        img.setMaxZoom(4f);
        setContentView(img);
    }    }