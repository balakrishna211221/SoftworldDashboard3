package com.example.softworlddashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class resetPassword extends AppCompatActivity {
    ImageButton imagebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        imagebutton=findViewById(R.id.resetpass);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(resetPassword.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
