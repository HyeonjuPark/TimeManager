package com.tomboy.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tomboy.timemanager.R;

/**
 * Created by imcreator on 16. 1. 15.
 */
public class WeekStatisticFragment extends android.support.v4.app.Fragment {
    public WeekStatisticFragment newInstance(){
        WeekStatisticFragment fragment = new WeekStatisticFragment();
        return fragment;
    }


    public WeekStatisticFragment() {

// Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_week_statistic, container, false);
    }
}
