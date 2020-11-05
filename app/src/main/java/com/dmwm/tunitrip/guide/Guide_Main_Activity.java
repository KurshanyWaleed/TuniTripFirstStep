package com.dmwm.tunitrip.guide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.dmwm.tunitrip.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Guide_Main_Activity extends AppCompatActivity {
    BottomNavigationView btmNavViewG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_main);


        btmNavViewG=findViewById(R.id.nav_bar_guide);
        getSupportFragmentManager().beginTransaction().replace(R.id.containerG,new Feed_Fragment_guide()).commit();

        btmNavViewG.setSelectedItemId(R.id.feedG);
        btmNavViewG.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()){

                    case R.id.profileG:
                        fragment=new Profile_Fragment_guide();
                        break;
                    case R.id.messagesG:
                        fragment=new Messages_Fragment_guide();
                        break;
                    case R.id.visitorG:
                        fragment=new Visitor_Fragment_guide();
                        break;
                    case R.id.feedG:
                        fragment=new Feed_Fragment_guide();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.containerG,fragment).commit();
                return true;



            }
        });
    }
}