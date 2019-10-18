package com.example.softworlddashboard;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import github.hellocsl.cursorwheel.CursorWheelLayout;

class WheelTextAdopter extends CursorWheelLayout.CycleWheelAdapter{
    Context context;
    String[] list;

    public WheelTextAdopter(Wheel2 mainActivity, String[] list) {
        this.list=list;
        this.context=mainActivity;
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public View getView(View parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wheel_text_layout,null);
        TextView textView;
        textView=view.findViewById(R.id.itemtext);

        textView.setText(list[position]);

        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        return view;
    }

    @Override
    public Object getItem(int position) {
        return list[position];
    }
}
