package com.example.uye.labsinfo;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by LENOVO IP300 on 19/07/2017.
 */

public class iconlistperaturan extends ArrayAdapter<String> {
    private final AppCompatActivity contextP;
    private final String[] listLabelPeraturan;
    private final Integer[] GbrListPeraturan;

    public iconlistperaturan(AppCompatActivity contextP, String[] listLabelPeraturan, Integer[] GbrListPeraturan) {
        super(contextP, R.layout.iperaturan, listLabelPeraturan);


        this.contextP=contextP;
        this.listLabelPeraturan= listLabelPeraturan;
        this.GbrListPeraturan=GbrListPeraturan;
    }

    public View getView(int positionP, View view, ViewGroup parent) {
        LayoutInflater inflater=contextP.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.liperaturan, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);


        txtTitle.setText(listLabelPeraturan[positionP]);
        imageView.setImageResource(GbrListPeraturan[positionP]);

        return rowView;

    };
}
