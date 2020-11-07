package com.dmwm.tunitrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dmwm.tunitrip.guide.Guide_Main_Activity;

public class RegistrationGuide_f extends AppCompatActivity {
            Button finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_guide_3);

    finish=(Button)findViewById(R.id.button_goNext);
    finish.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), Guide_Main_Activity.class);
            startActivity(i);
        }
    });








    }
}