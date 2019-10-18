package com.example.softworlddashboard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

import github.hellocsl.cursorwheel.CursorWheelLayout;

class FragmentAssignment extends Fragment{
    int pStatus = 0;
    private Handler handler = new Handler();
    TextView tv2;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getActivity().setTitle("Assignment");

        View view = inflater.inflate(R.layout.assignment, container, false);

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circle);
        final ProgressBar mProgress = (ProgressBar) view.findViewById(R.id.totalstatus);
        mProgress.setProgress(0);   // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);
        tv2 = view.findViewById(R.id.totalstatustextvalue);


        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (pStatus < 76) {
                    pStatus += 1;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mProgress.setProgress(pStatus);


                            tv2.setText(pStatus+"%");


                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(8); //thread will take approx 1.5 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        return view;
    }



}
