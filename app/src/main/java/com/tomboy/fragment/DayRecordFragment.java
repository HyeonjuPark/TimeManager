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

// Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

// Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_day_record, container, false);
//        ListView listview = (ListView) view.findViewById(R.id.listView);
//        populateList();
//        DayRecordListAdapter adapter = new DayRecordListAdapter(getActivity(),list);
//        listview.setAdapter(adapter);
        View view = inflater.inflate(R.layout.fragment_day_record, container, false);
        populateList();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new DayRecordRecyclerViewAdapter(list);
        mRecyclerView.setAdapter(mAdapter);
//        RecyclerView.ItemDecoration itemDecoration =
//                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
//        mRecyclerView.addItemDecoration(itemDecoration);
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
//            cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR)+1);
//            cal.set(Calendar.MINUTE, 0);
//            time = timeFormat.format(date);
//            time += "-";
//            cal.set(Calendar.MINUTE,30);
//            date = cal.getTime();
//            time += timeFormat.format(date);
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

//        DayRecord tmp1 = new DayRecord();
//        tmp1.setTime("9:00~9:30");
//        tmp1.setContent("씻기");
//        tmp1.setImportance(true);
//        tmp1.setUrgency(true);
//        list.add(tmp1);
//
//        DayRecord tmp2 = new DayRecord();
//        tmp2.setTime("9:30~10:00");
//        tmp2.setContent("등교");
//        tmp2.setImportance(true);
//        tmp2.setUrgency(true);
//        list.add(tmp2);
//
//        DayRecord tmp3 = new DayRecord();
//        tmp3.setTime("10:00~10:30");
//        tmp3.setContent("영작 공부");
//        tmp3.setImportance(true);
//        tmp3.setUrgency(false);
//        list.add(tmp3);
//
//        DayRecord tmp4 = new DayRecord();
//        tmp4.setTime("10:30~11:00");
//        tmp4.setContent("논문번역");
//        tmp4.setImportance(true);
//        tmp4.setUrgency(true);
//        list.add(tmp4);

    }
}
