package com.tomboy.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tomboy.timemanager.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by imcreator on 16. 1. 15.
 */
public class DayRecordFragment extends android.support.v4.app.Fragment {
    private ArrayList<HashMap> list;

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
        View view = inflater.inflate(R.layout.fragment_day_record, container, false);
        ListView listview = (ListView) view.findViewById(R.id.listView);
        populateList();
        DayRecordListAdapter adapter = new DayRecordListAdapter(getActivity(),list);
        listview.setAdapter(adapter);
        return view;
    }

    private void populateList() {
        list = new ArrayList<HashMap>();

        HashMap tmp = new HashMap();
        tmp.put("time", "9:00~9:30");
        tmp.put("content", "씻기");
        tmp.put("importance", "Y");
        tmp.put("urgency", "Y");
        list.add(tmp);

        HashMap tmp1 = new HashMap();
        tmp.put("time", "9:30~10:00");
        tmp.put("content", "등교");
        tmp.put("importance", "Y");
        tmp.put("urgency", "Y");
        list.add(tmp1);

        HashMap tmp2 = new HashMap();
        tmp.put("time", "10:00~10:30");
        tmp.put("content", "영작 공부");
        tmp.put("importance", "Y");
        tmp.put("urgency", "N");
        list.add(tmp2);

        HashMap tmp3 = new HashMap();
        tmp.put("time", "10:30~11:00");
        tmp.put("content", "논문번역");
        tmp.put("importance", "Y");
        tmp.put("urgency", "Y");
        list.add(tmp3);
    }
}
