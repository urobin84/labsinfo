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

public class iconlistasisten extends ArrayAdapter<String> {
    private final AppCompatActivity contextAs;
    private final String[] listLabelAsisten;
    private final Integer[] GbrListAsisten;

    public iconlistasisten(AppCompatActivity contextAs, String[] listLabelAsisten, Integer[] GbrListAsisten) {
        super(contextAs, R.layout.iasisten, listLabelAsisten);


        this.contextAs=contextAs;
        this.listLabelAsisten= listLabelAsisten;
        this.GbrListAsisten=GbrListAsisten;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=contextAs.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.liasisten, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);


        txtTitle.setText(listLabelAsisten[position]);
        imageView.setImageResource(GbrListAsisten[position]);

        return rowView;

    };
}
