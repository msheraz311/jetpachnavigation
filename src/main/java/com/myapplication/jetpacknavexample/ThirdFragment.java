package com.myapplication.jetpacknavexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

TextView dataa;
    public ThirdFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_third, container, false);

        dataa = v.findViewById(R.id.showtext);
       // Bundle bundle = this.getArguments();
       // String dat = SecondFragment.data;
        dataa.setText(getArguments().getString("data"));

        return v;
    }
}