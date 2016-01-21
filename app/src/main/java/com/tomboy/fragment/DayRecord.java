package com.tomboy.fragment;

import java.util.ArrayList;

/**
 * Created by imcreator on 16. 1. 15.
 */
public class DayRecord {
    static final String YES = "Y";
    static final String NO = "N";
    ArrayList<String> times;
    String time;
    String content;
    String importance;
    String urgency;

    DayRecord(int recordInterval){ //recordInterval unit: minutes
        times = new ArrayList<String>();
        for(int i=0; i< 24*60; i+=recordInterval){
            times.add("");
        }
    }
}
