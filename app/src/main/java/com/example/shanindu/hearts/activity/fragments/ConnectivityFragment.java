package com.example.shanindu.hearts.activity.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shanindu.hearts.R;
import com.example.shanindu.hearts.activity.HomeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConnectivityFragment extends Fragment {



    public ConnectivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TextView textView = new TextView(getActivity());
        return textView;
    }

}
