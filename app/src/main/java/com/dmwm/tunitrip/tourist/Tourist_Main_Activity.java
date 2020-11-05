package com.dmwm.tunitrip.tourist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.dmwm.tunitrip.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Tourist_Main_Activity extends AppCompatActivity {
    BottomNavigationView btmNavViewT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_main);


        btmNavViewT=(BottomNavigationView) findViewById(R.id.nav_bar_tourist);
        btmNavViewT.setOnNavigationItemSelectedListener(navBarMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.containerT,new Feed_Fragment_tourist()).commit();
    }
    BottomNavigationView.OnNavigationItemSelectedListener navBarMethod= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;
            switch (item.getItemId()){

                case R.id.profileT:
                    fragment=new Profile_Fragment_tourist();

                    break;
                case R.id.messagesT:
                    fragment=new Messages_Fragment_tourist();
                    break;
                case R.id.favouriteT:
                    fragment=new Favourite_Fragment_tourist();
                    break;
                case R.id.feedT:
                    fragment=new Feed_Fragment_tourist();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.containerT,fragment).commit();



            return true;
        }
    };
}