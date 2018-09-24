package com.example.shanindu.hearts.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shanindu.hearts.R;
import com.example.shanindu.hearts.model.meals;

import java.util.List;

public class mealsAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<meals> mealList;


    public mealsAdapter(Activity activity, List<meals> mealItems) {
        this.activity = activity;
        this.mealList = mealItems;

    }

    @Override
    public int getCount() {
        return mealList.size();
    }

    @Override
    public Object getItem(int location) {
        return mealList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row_meal, null);


        TextView sdate = (TextView) convertView.findViewById(R.id.sdate);
        TextView edate = (TextView) convertView.findViewById(R.id.edate);
        TextView type = (TextView) convertView.findViewById(R.id.type);
        TextView desc = (TextView) convertView.findViewById(R.id.desc);


        // getting customer data for the row
        meals m = mealList.get(position);


        // start date
        sdate.setText(m.getSdate() + "");

        // end date
        edate.setText(m.getEdate() + "");

        // type
        type.setText(m.getType() + "");

        // description
        desc.setText(m.getDesc() + "");


        return convertView;
    }

}
