package com.myapplication.jetpacknavexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**

 */
public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public static CountDownTimer countDownTimer;
   TextView timer;
    public FirstFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        timer = v.findViewById(R.id.timer);
        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


      /*  Thread splashThread = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(5000);

                    navcontroller.navigate(R.id.action_firstFragment_to_secondFragment);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        splashThread.start();*/
      countDownTimer = new CountDownTimer(5000,1000) {
          @Override
          public void onTick(long millisUntilFinished) {
              timer.setText(millisUntilFinished/1000 + " Sec wait to load next screen");
          }

          @Override
          public void onFinish() {

          }
      };
        countDownTimer.start();

        final NavController navcontroller = Navigation.findNavController(view);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navcontroller.navigate(R.id.action_firstFragment_to_secondFragment);
            }
        },5000);

    }


}
