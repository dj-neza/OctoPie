package com.example.neza.octopie;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class Onboarding extends AppCompatActivity {

    private static final int NUM_PAGES = 4;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NormalFr frg=new NormalFr();//create the fragment instance for the top fragment
        Fit frg1=new Fit();//create the fragment instance for the middle fragment
        Vegan frg2=new Vegan();//create the fragment instance for the bottom fragment
        Allergy frg3 = new Allergy();

        FragmentManager manager=getSupportFragmentManager();//create an instance of fragment manager

        FragmentTransaction transaction=manager.beginTransaction();//create an instance of Fragment-transaction

        transaction.add(R.id.nm_frag, frg, "Frag_Top_tag");
        transaction.add(R.id., frg1, "Frag_Middle_tag");
        transaction.add(R.id.My_Container_3_ID, frg2, "Frag_Bottom_tag");


        transaction.commit();
    }

}
