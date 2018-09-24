package com.example.shanindu.hearts.activity.fragments;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.shanindu.hearts.R;
import com.example.shanindu.hearts.adapter.mealsAdapter;
import com.example.shanindu.hearts.model.meals;
import com.example.shanindu.hearts.support.sharedPref;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class MealFragment extends Fragment {

    private TextView tvStartDate, tvEndDate;
    private EditText edtDescription;
    private Calendar mCurrentDate;
    private int day, month, year;
    private String mealType;
    private RadioButton rdoBreakfast, rdoLunch, rdoDinner;
    private Button btnAddSchedule, btnSave;
    private ListView listMeal;
    private mealsAdapter mealListAdapter;
    ArrayList<meals> mealArray = new ArrayList<meals>();
    private ProgressDialog pDialog;
    sharedPref pref = new sharedPref(getApplicationContext());

    private final int elder = 1; //elder identifies from 1
    private final int careGiver = 0; //caregiver identifies from 2


    public MealFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_meal, container, false);
        tvStartDate = rootView.findViewById(R.id.tv_meal_start_date);
        tvEndDate = rootView.findViewById(R.id.tv_meal_end_date);
        rdoBreakfast = rootView.findViewById(R.id.rdoBreakfast);
        rdoLunch = rootView.findViewById(R.id.rdoLunch);
        rdoDinner = rootView.findViewById(R.id.rdoDinner);
        edtDescription = rootView.findViewById(R.id.edt_meal_description);
        btnAddSchedule = rootView.findViewById(R.id.btn_add_meal_schedule);
        btnSave = rootView.findViewById(R.id.btn_meal_save);
        listMeal = rootView.findViewById(R.id.list_meal);



        tvStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        tvStartDate.setText(year + " / " + (month + 1) + " / " + dayOfMonth);
                    }
                }, year, month, day);
                dp.show();
            }
        });

        tvEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        tvEndDate.setText(year + " / " + (month + 1) + " / " + dayOfMonth);
                    }
                }, year, month, day);
                dp.show();
            }
        });


        btnAddSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdoBreakfast.isChecked()) {
                    mealType = "Breakfast";
                } else if (rdoLunch.isChecked()) {
                    mealType = "Lunch";
                } else if (rdoDinner.isChecked()) {
                    mealType = "Dinner";
                }


                mealArray.add(new meals(tvStartDate.getText().toString().trim(), tvEndDate.getText().toString().trim(), mealType, edtDescription.getText().toString().trim()));
                mealListAdapter = new mealsAdapter(getActivity(), mealArray);
                listMeal.setAdapter(mealListAdapter);
                mealListAdapter.notifyDataSetChanged();

                tvStartDate.setText("");
                tvEndDate.setText("");
                edtDescription.setText("");

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mealArray.size(); i++) {
                    saveSchedules(mealArray.get(i).getSdate(), mealArray.get(i).getEdate(), mealArray.get(i).getType(), mealArray.get(i).getDesc());
                }
            }
        });
        // Inflate the layout for this fragment
        return rootView;

    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    public void  saveSchedules( String sdate,String edate, String type, String desc)
    {
        if(pref.getUserType()==elder)
        {

        }
    }

    public Context getApplicationContext() {
        return getApplicationContext();
    }
}

