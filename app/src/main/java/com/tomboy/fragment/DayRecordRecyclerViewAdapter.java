package com.tomboy.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.tomboy.timemanager.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by imcreator on 16. 1. 22.
 */
public class DayRecordRecyclerViewAdapter extends RecyclerView
        .Adapter<DayRecordRecyclerViewAdapter
        .DayRecordHolder>{

    private static String LOG_TAG = "DayRecordRecyclerViewAdapter";
    private ArrayList<DayRecord> mDataset;
    private static MyClickListener myClickListener;

    public static class DayRecordHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        TextView time;
        TextView content;
//        Switch i_switch;
//        Switch u_switch;

        public DayRecordHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.recyclerview_time);
            content = (TextView) itemView.findViewById(R.id.recyclerview_content);
//            i_switch = (Switch) itemView.findViewById(R.id.importance_switch);
//            u_switch = (Switch) itemView.findViewById(R.id.urgency_switch);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public DayRecordRecyclerViewAdapter(ArrayList<DayRecord> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public DayRecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        DayRecordHolder dayRecordHolder = new DayRecordHolder(view);
        return dayRecordHolder;
    }

    @Override
    public void onBindViewHolder(DayRecordHolder holder, int position) {
        holder.time.setText(mDataset.get(position).getTime());
        holder.content.setText(mDataset.get(position).getContent());
//        if(mDataset.get(position).getImportance())
//            holder.i_switch.setChecked(true);
//        else
//            holder.i_switch.setChecked(false);
//        if(mDataset.get(position).getUrgency())
//            holder.u_switch.setChecked(true);
//        else
//            holder.u_switch.setChecked(false);
    }

    public void addItem(DayRecord dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }


}
