package com.example.softworlddashboard;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import github.hellocsl.cursorwheel.CursorWheelLayout;

class FragmentHome extends Fragment {

    int pStatus = 0;



    private Handler handler = new Handler();
    TextView tv, tv2, tv3, tv4 ,tv5,scheduleclasses;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getActivity().setTitle("Home");

        View view = inflater.inflate(R.layout.home, container, false);

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circle);
        final ProgressBar mProgress = (ProgressBar) view.findViewById(R.id.circularProgressbar);
        final ProgressBar mProgress2 = (ProgressBar) view.findViewById(R.id.circularProgressbar2);
        final ProgressBar mProgress3 = (ProgressBar) view.findViewById(R.id.circularProgressbar3);
        final ProgressBar mProgress4 = (ProgressBar) view.findViewById(R.id.circularProgressbar4);
        final ProgressBar mProgress5 = (ProgressBar) view.findViewById(R.id.circularProgressbar5);
        mProgress.setProgress(0);   // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);


        tv = (TextView) view.findViewById(R.id.tv);

        tv2 = (TextView) view.findViewById(R.id.tv2);

        tv3 = (TextView) view.findViewById(R.id.tv3);

        tv4 = (TextView) view.findViewById(R.id.tv4);

        tv5=(TextView)view.findViewById(R.id.tv5);
        scheduleclasses=view.findViewById(R.id.scheduleclasses);
        scheduleclasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Wheel2.class);
            }
        });


        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (pStatus < 100) {
                    pStatus += 1;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mProgress.setProgress(pStatus);

                            mProgress2.setProgress(pStatus);
                            mProgress3.setProgress(pStatus);
                            mProgress4.setProgress(pStatus);
                            mProgress5.setProgress(pStatus);

                            tv.setText(pStatus + "%");
                            tv2.setText(pStatus + "%");
                            tv3.setText(pStatus + "%");
                            tv4.setText(pStatus + "%");
                            tv5.setText(pStatus + "%");

                            if (pStatus == 100) {
                                tv.setText("OK");
                                tv2.setText("OK");
                                tv3.setText("OK");
                                tv4.setText("OK");
                                tv5.setText("ok");
                            }

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


        //wheel



        return view;
    }



}
