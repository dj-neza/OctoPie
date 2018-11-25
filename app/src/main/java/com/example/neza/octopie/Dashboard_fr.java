package com.example.neza.octopie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Dashboard_fr extends Fragment {

    public Dashboard_fr() {
        // Required empty public constructor
    }

    public static Dashboard_fr newInstance(String param1, String param2) {
        Dashboard_fr fragment = new Dashboard_fr();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_dashboard, container, false);
    }

}
