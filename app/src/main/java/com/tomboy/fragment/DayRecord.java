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
    Boolean importance;
    Boolean urgency;

    DayRecord(){
        importance = false;
        urgency = false;
    }

    DayRecord(int recordInterval){ //recordInterval unit: minutes
        times = new ArrayList<String>();
        for(int i=0; i< 24*60; i+=recordInterval){
            times.add("");
        }
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getImportance() {
        return importance;
    }

    public void setImportance(Boolean importance) {
        this.importance = importance;
    }

    public Boolean getUrgency() {
        return urgency;
    }

    public void setUrgency(Boolean urgency) {
        this.urgency = urgency;
    }
}
