package com.myapplication.jetpacknavexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    EditText text;
    Button senddata;
    public static String data = "";

    public SecondFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_second, container, false);
       text = view.findViewById(R.id.text);
       senddata =view.findViewById(R.id.btn2);



       return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navcontroller = Navigation.findNavController(view);


        senddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Bundle bundle = new Bundle();
               bundle.putString("data",text.getText().toString());

                data = text.getText().toString();
                navcontroller.navigate(R.id.action_secondFragment_to_thirdFragment,bundle);

            }
        });
    }
}