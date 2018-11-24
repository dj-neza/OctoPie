package com.example.neza.octopie;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class Onboarding extends FragmentActivity {

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

        transaction.add(R.id.nm_frag, frg);
        transaction.add(R.id.fit_frag, frg1);
        transaction.add(R.id.veg_frag, frg2);
        //transaction.add(R.id.all_frag, frg3);


        transaction.commit();
    }

}
