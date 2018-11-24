package com.example.neza.octopie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;

public class Onboarding extends Activity {

    GridView gridView;
    public static final String MY_PREFS_NAME = "MyPref";
    static final String[] MOBILE_OS = new String[] {
            "Normal", "Fit","Vegan", "Allergies", "Gluten-free" };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        defaultOcto();

        gridView = (GridView) findViewById(R.id.gridView1);

        gridView.setAdapter(new MyAdapter(this, MOBILE_OS));

        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // chosen profile R.id.grid_item_label

                Toast.makeText(
                        getApplicationContext(),
                        ((TextView) v.findViewById(R.id.grid_item_label))
                                .getText(), Toast.LENGTH_SHORT).show();
                String chosen = ((TextView) v.findViewById(R.id.grid_item_label)).getText().toString();
                SharedPreferences pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                if (chosen.equals("Normal")) {
                    editor.putInt("octoId", 0);
                }
                else if (chosen.equals("Fit")) {
                    editor.putInt("octoId", 1);
                }
                else if (chosen.equals("Vegan")) {
                    editor.putInt("octoId", 2);
                }
                else if (chosen.equals("Allergies")) {
                    editor.putInt("octoId", 3);
                }
                else {
                    editor.putInt("octoId", 4);
                }

                editor.apply();

                Intent intent = new Intent(Onboarding.this, Dashboard.class);
                startActivity(intent);
            }

        });

    }

    public void defaultOcto() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("octoId", 1);
        editor.apply();
    }

}
