package com.example.softworlddashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    ImageButton imgbtn;
    TextView forgettv,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


       signup=findViewById(R.id.signup);
       signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(LoginActivity.this,RegActivity.class);
               startActivity(intent);
           }
       });
        imgbtn = findViewById(R.id.loginbt);
        forgettv=findViewById(R.id.forgotpass);
       forgettv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,forgetPassword.class);
                startActivity(intent);
            }
        });
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        overridePendingTransition(0,0);
        View relativeLayout=findViewById(R.id.ll);
        Animation animation= AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        relativeLayout.startAnimation(animation);

    }
}
