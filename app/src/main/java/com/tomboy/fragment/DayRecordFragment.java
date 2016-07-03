package com.tomboy.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tomboy.timemanager.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by imcreator on 16. 1. 15.
 */
public class DayRecordFragment extends android.support.v4.app.Fragment {
    private ArrayList<DayRecord> list;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public DayRecordFragment newInstance(){
        DayRecordFragment fragment = new DayRecordFragment();
        return fragment;
    }

    public DayRecordFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_day_record, container, false);
        populateList();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new DayRecordRecyclerViewAdapter(list);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    private void populateList() {
        list = new ArrayList<DayRecord>();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 0);
        Date date = cal.getTime();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String time;

        for(int i=0; i<24; i++){
            DayRecord dr = new DayRecord();
            time = timeFormat.format(date) + "-";
            cal.set(Calendar.MINUTE,cal.get(Calendar.MINUTE)+30);
            date = cal.getTime();
            time += timeFormat.format(date);
            dr.setTime(time);
            list.add(dr);
        }

        list.get(0).setContent("씻기");
        list.get(0).setImportance(true);
        list.get(0).setUrgency(true);

        list.get(1).setContent("등교");
        list.get(1).setImportance(true);
        list.get(1).setUrgency(true);

        list.get(2).setContent("영작 공부");
        list.get(2).setImportance(true);
        list.get(2).setUrgency(true);

        list.get(3).setContent("논문 번역");
        list.get(3).setImportance(true);
        list.get(3).setUrgency(true);

    }
}
