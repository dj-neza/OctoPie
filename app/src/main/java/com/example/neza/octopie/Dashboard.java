package com.example.neza.octopie;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neza.octopie.Dashboard;
import com.example.neza.octopie.Recipes;
import com.example.neza.octopie.Statistics;
import com.example.neza.octopie.ShoppingList;


public class Dashboard extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "MyPref";
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        SharedPreferences sp = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        int lala = sp.getInt("octoId", 0);

        ImageView myImageView = (ImageView) findViewById(R.id.profile_octo);
        TextView profile = (TextView) findViewById(R.id.profile_text);
        if (lala == 0) {
            myImageView.setImageResource(R.drawable.octo01);
            profile.setText("Normal");
        } else if (lala == 1) {
            myImageView.setImageResource(R.drawable.octo02);
            profile.setText("Fit");
        } else if (lala == 2) {
            myImageView.setImageResource(R.drawable.octo03);
            profile.setText("Vegan");
        } else if (lala == 3) {
            myImageView.setImageResource(R.drawable.octo04);
            profile.setText("Allergies");
        } else {
            myImageView.setImageResource(R.drawable.octo05);
            profile.setText("Gluten-free");
        }

        // overall score based on products
        TextView score = (TextView) findViewById(R.id.overall_score);
        int procent = 0;
        score.setText("Your success based on profile setting: " + procent + " %");

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("Dashboard");
        //loadFragment(new StoreFragment());

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.dashboard:
                    toolbar.setTitle("Dashboard");
                    fragment = new Dashboard();
                    loadFragment(fragment);
                    return true;
                case R.id.shop_list:
                    toolbar.setTitle("Shopping list");
                    fragment = new ShoppingList();
                    loadFragment(fragment);
                    return true;
                case R.id.statistics:
                    toolbar.setTitle("Statistics");
                    fragment = new Statistics();
                    loadFragment(fragment);
                    return true;
                case R.id.recipes:
                    toolbar.setTitle("Recipes");
                    fragment = new Recipes();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}

