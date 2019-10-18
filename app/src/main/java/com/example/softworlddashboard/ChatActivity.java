package com.example.softworlddashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity {
ImageView imageView;
TextView textView;
EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

imageView=findViewById(R.id.chatsend);

       // textView=findViewById(R.id.chatsenttext);
        editText=findViewById(R.id.typemsg);
      //  final String msg=editText.getText().toString().trim();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String msg=editText.getText().toString().trim();
                textView.setText(msg);
                textView.setVisibility(View.VISIBLE);
                Toast.makeText(ChatActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)  {
        getMenuInflater().inflate(R.menu.chat_menu,menu );
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.chat_to_home){
            Intent intent=new Intent(ChatActivity.this,MainActivity.class);
            startActivity(intent);


        }

        if(id == R.id.ChatMenuFont){
            // do somethingChatMenubackgound
        }

        if(id == R.id.ChatMenubackgound){
            // do somethingChatMenubackgound
        }
        return super.onOptionsItemSelected(item);
    }

}
