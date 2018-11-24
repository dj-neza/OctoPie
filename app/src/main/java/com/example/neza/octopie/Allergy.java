package com.example.neza.octopie;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.neza.octopie.ui.allergy.AllergyFragment;

public class Allergy extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            /**
             * Inflate the layout for this fragment
             */
            return inflater.inflate(R.layout.allergy_fragment, container, false);
        }
    }
