package com.example.softworlddashboard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import github.hellocsl.cursorwheel.CursorWheelLayout;

public class Wheel2 extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener {
    CursorWheelLayout cursorWheelLayout;
    TextView textView;
    String names[]={"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};

    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel2);

textView=findViewById(R.id.scheduletext);




        try {
            cursorWheelLayout = findViewById(R.id.curserwheel);
            WheelTextAdopter wheelTextAdopter = new WheelTextAdopter(Wheel2.this, names);
            cursorWheelLayout.setAdapter(wheelTextAdopter);

        } catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();


        }
        cursorWheelLayout.setOnMenuSelectedListener(  Wheel2.this);
    }


    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {

        textView.setText(names[pos]);
    }


}
