package com.example.softworlddashboard;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.roughike.bottombar.BottomBarBadge;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import github.hellocsl.cursorwheel.CursorWheelLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     frameLayout=findViewById(R.id.frame);

        bottomNavigationView=findViewById(R.id.bottombar1);

          bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction fragmentHomet=getSupportFragmentManager().beginTransaction();
        FragmentHome  fragmentHome=new FragmentHome();
        fragmentHomet.addToBackStack("FrameHome");
        FragmentTransaction replace = fragmentHomet.add(R.id.frame,fragmentHome );
        fragmentHomet.commit();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {


Intent intent=new Intent(MainActivity.this,ChatActivity.class);
startActivity(intent);
            }
        });





        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);





    }





    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    FragmentTransaction fragmentHomet=getSupportFragmentManager().beginTransaction();
                    FragmentHome  fragmentHome=new FragmentHome();
                    fragmentHomet.addToBackStack("FrameHome");
                    FragmentTransaction replace = fragmentHomet.replace(R.id.frame,fragmentHome );
                    fragmentHomet.commit();



                    return true;
                case R.id.bottom_refer:
                    Toast.makeText(MainActivity.this, "refer", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.trainerinfo:
                    Toast.makeText(MainActivity.this, "Trainer", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };






    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Course) {

            FragmentTransaction FrameRegT=getSupportFragmentManager().beginTransaction();
            FragmentCourseInfo     fragmentCourseInfo=new FragmentCourseInfo();
            FrameRegT.addToBackStack("FrameHome");
            FragmentTransaction replace = (FragmentTransaction) FrameRegT.replace(R.id.frame,fragmentCourseInfo );
            FrameRegT.commit();



            onBackPressed();



            //Intent intent =new Intent(MainActivity.this, Wheel2.class);
          //  startActivity(intent);

            return true;
        } else if (id == R.id.nav_Reg) {

            FragmentTransaction FrameRegT=getSupportFragmentManager().beginTransaction();
            FragmentRegistration      fragmentRegistration=new FragmentRegistration();
            FrameRegT.addToBackStack("FrameHome");
            FragmentTransaction replace = (FragmentTransaction) FrameRegT.replace(R.id.frame,fragmentRegistration );
            FrameRegT.commit();

            onBackPressed();
            return true;
        } else if (id == R.id.nav_Assignments) {


            FragmentTransaction FrameAssignmentT=getSupportFragmentManager().beginTransaction();
            FragmentAssignment   fragmentAssignment=new FragmentAssignment();
            FrameAssignmentT.addToBackStack("fragmentAssignment");
            FragmentTransaction replace = (FragmentTransaction) FrameAssignmentT.replace(R.id.frame,fragmentAssignment );
            FrameAssignmentT.commit();

            onBackPressed();/*
            /*
            FragmentTransaction frameChatT=getSupportFragmentManager().beginTransaction();
            Fragmentchat     fragmentchat=new Fragmentchat();
            frameChatT.addToBackStack("fragmentchat");
            FragmentTransaction replace = (FragmentTransaction) frameChatT.replace(R.id.frame,fragmentchat );
            frameChatT.commit();

            onBackPressed();*/
            return true;
        } else if (id == R.id.nav_Coursesch) {
            Intent intent = new Intent(MainActivity.this, Wheel2.class);
            startActivity(intent);

           /* FragmentTransaction FrameCourseScheduleT=getSupportFragmentManager().beginTransaction();
            FragmentCourseSchedule    fragmentCourseSchedule=new FragmentCourseSchedule();
            FrameCourseScheduleT.addToBackStack("fragmentCourseSchedule");
            FragmentTransaction replace = (FragmentTransaction) FrameCourseScheduleT.replace(R.id.frame,fragmentCourseSchedule );
            FrameCourseScheduleT.commit();
*/
            onBackPressed();
            return true;

         /*   FragmentTransaction FrameCourseT=getSupportFragmentManager().beginTransaction();
            FragmentCourseInfo    fragmentCourseInfo=new FragmentCourseInfo();
            FrameCourseT.addToBackStack("fragmentCourseInfo");
            FragmentTransaction replace = (FragmentTransaction) FrameCourseT.replace(R.id.frame,fragmentCourseInfo );
            FrameCourseT.commit();

            onBackPressed();
            return true;
*/
        } else if (id == R.id.nav_Refer) {


        } else if (id == R.id.nav_AboutUs) {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://softworldusa.com/about/"));
            startActivity(viewIntent);
            return true;
        }
        else if (id == R.id.nav_Contactus) {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://softworldusa.com/contacts/"));
            startActivity(viewIntent);
        }
        else if (id == R.id.nav_Logout) {
            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }


        else if (id == R.id.nav_chat) {

            Intent intent=new Intent(MainActivity.this,ChatActivity.class);
            startActivity(intent);
        }





        return true;
    }






}
