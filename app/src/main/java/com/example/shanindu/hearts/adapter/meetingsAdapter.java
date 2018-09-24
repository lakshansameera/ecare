package com.example.shanindu.hearts.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shanindu.hearts.R;
import com.example.shanindu.hearts.model.meetings;

import java.util.List;

public class meetingsAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<meetings> doctorList;


    public meetingsAdapter(Activity activity, List<meetings> customerItems) {
        this.activity = activity;
        this.doctorList = customerItems;

    }

    @Override
    public int getCount()
    {
        return doctorList.size();
    }

    @Override
    public Object getItem(int location)
    {
        return doctorList.get(location);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row_doctor, null);


        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView time = (TextView) convertView.findViewById(R.id.time);
        TextView doctor = (TextView) convertView.findViewById(R.id.doctor);
        TextView location = (TextView) convertView.findViewById(R.id.location);


        // getting customer data for the row
        meetings m = doctorList.get(position);


        // date
        date.setText(m.getDate() + "");

        // time
        time.setText(m.getTime() + "");

        // doctor
        doctor.setText(m.getName() + "");

        // location
        location.setText(m.getLocation() + "");


        return convertView;
    }

}
