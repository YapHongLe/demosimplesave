package com.example.demosimplesave;

import android.arch.lifecycle.OnLifecycleEvent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onPause() {
        super.onPause();

        //Step 1a
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 1b
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Step 1c
        prefEdit.putString("greetings", "Hello!");

        //Step 1d
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //String msg = "No greetings!";

        //Step 2a
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 2b
        String msg = prefs.getString("greetings", "No greetings!");


        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();
    }



    }

