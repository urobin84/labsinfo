package com.example.uye.labsinfo;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;


public class Main extends AppCompatActivity {
    ListView list;
    Intent intent;
    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();
    // Session Manager Class
    SessionManager session;

    //data dalam bentuk array
    String[] listLabelHome={
            "Asisten",
            "Peraturan",
            "Administrasi"};
    Integer[] GbrListHome={
            R.mipmap.asistenhome,
            R.mipmap.rules,
            R.mipmap.bioasisten,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_action);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.main);

        // Session class instance
        session = new SessionManager(getApplicationContext());


        iconlisthome adapter = new iconlisthome(this, listLabelHome, GbrListHome);
        list =(ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
        //Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();

        // name
        String name = user.get(SessionManager.KEY_NAME);

        // password
        String password = user.get(SessionManager.KEY_PASSWORD);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String Pilihitem = listLabelHome[+position];
                Toast.makeText(getApplicationContext(), Pilihitem, Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    intent = new Intent(getApplicationContext(), iasisten.class);
                    startActivity(intent);
                } else if (position == 1) {
                    intent = new Intent(getApplicationContext(), iperaturan.class);
                    startActivity(intent);
                } else if (position == 2) {
                    intent = new Intent(getApplicationContext(), iadministrasi.class);
                    startActivity(intent);
                } else {
                    Toast t = Toast.makeText(getApplicationContext(), listLabelHome[position], Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
                    t.show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuacb, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                // Clear the session data
                // This will clear all session data and
                // redirect user to LoginActivity
                session.logoutUser();
                finish();
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent dev = new Intent(this, developer.class);
                startActivity(dev);
                return true;
            case R.id.Help:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent ihelp = new Intent(this, help.class);
                startActivity(ihelp);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setMessage("yakin ingin keluar?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        finishAffinity();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}