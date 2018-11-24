package com.example.neza.octopie;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Recipes extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "MyPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        TextView tw = findViewById(R.id.text2);
        SharedPreferences sp = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        int lala = sp.getInt("octoId", 0);
        tw.setText(String.valueOf(lala));
    }
}
