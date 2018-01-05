package com.example.uye.labsinfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
/**
 * Created by LENOVO IP300 on 17/07/2017.
 */

public class iconlisthome extends ArrayAdapter<String>{
    private final AppCompatActivity context;
    private final String[] listLabelHome;
    private final Integer[] GbrListHome;

    public iconlisthome(AppCompatActivity context, String[] listLabelHome, Integer[] GbrListHome) {
        super(context, R.layout.main, listLabelHome);


        this.context=context;
        this.listLabelHome= listLabelHome;
        this.GbrListHome=GbrListHome;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.llist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);


        txtTitle.setText(listLabelHome[position]);
        imageView.setImageResource(GbrListHome[position]);

        return rowView;

    };
}

