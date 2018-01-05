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

public class iconlistadministrasi extends ArrayAdapter<String> {
    private final AppCompatActivity contextAdm;
    private final String[] listLabelAdministrasi;
    private final Integer[] GbrListAdministrasi;

    public iconlistadministrasi(AppCompatActivity contextAdm, String[] listLabelAdministrasi, Integer[] GbrListAdministrasi) {
        super(contextAdm, R.layout.iadministrasi, listLabelAdministrasi);


        this.contextAdm=contextAdm;
        this.listLabelAdministrasi= listLabelAdministrasi;
        this.GbrListAdministrasi=GbrListAdministrasi;
    }

    public View getView(int positionAdm, View view, ViewGroup parent) {
        LayoutInflater inflater=contextAdm.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.liadministrasi, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);


        txtTitle.setText(listLabelAdministrasi[positionAdm]);
        imageView.setImageResource(GbrListAdministrasi[positionAdm]);

        return rowView;

    };
}
