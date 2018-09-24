package com.example.shanindu.hearts.activity.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shanindu.hearts.R;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddElderFragment extends Fragment {


    public AddElderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TextView textView = new TextView(getActivity());

        return textView;
    }

}
