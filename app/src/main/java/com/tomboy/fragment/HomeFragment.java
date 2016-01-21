package com.tomboy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tomboy.timemanager.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by imcreator on 16. 1. 18.
 */
public class HomeFragment extends android.support.v4.app.Fragment {
    private ArrayList<HashMap> list;

    public HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    public HomeFragment() {

// Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}
