package com.tomboy.fragment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tomboy.timemanager.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by imcreator on 16. 1. 15.
 */
public class DayRecordListAdapter extends BaseAdapter {
    ArrayList<HashMap> list;
    Activity activity;

    public DayRecordListAdapter(Activity activity, ArrayList<HashMap> list){
        super();
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView time;
        TextView content;
        TextView importance;
        TextView urgency;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if(convertView == null){
            convertView = inflater.inflate(R.layout.listview_row, null);
            holder = new ViewHolder();
            holder.time = (TextView) convertView.findViewById(R.id.listview_time);
            holder.content = (TextView) convertView.findViewById(R.id.listview_content);
            holder.importance = (TextView) convertView.findViewById(R.id.listview_importance);
            holder.urgency = (TextView) convertView.findViewById(R.id.listview_urgency);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
            if(holder == null)
                holder = new ViewHolder();
        }

        HashMap map = list.get(position);
        holder.time.setText((String)map.get("time"));
        holder.content.setText((String)map.get("content"));
        holder.importance.setText((String)map.get("importance"));
        holder.urgency.setText((String)map.get("urgency"));

        return convertView;
    }
}
