package com.dmwm.tunitrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Registration_Tourist extends AppCompatActivity {

    Button btnnext;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__tourist);
        img=(ImageView) findViewById(R.id.tourist_switch);
             btnnext=(Button) findViewById(R.id.button_finish);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistrationTourist_f.class);
                startActivity(i);
            }
        });

           img.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent ii = new Intent(getApplicationContext(), Registration_Guide.class);
        startActivity(ii);

    }
});






    }
}