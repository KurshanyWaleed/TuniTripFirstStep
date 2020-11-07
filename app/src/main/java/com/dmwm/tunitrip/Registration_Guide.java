package com.dmwm.tunitrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registration_Guide extends AppCompatActivity {
    Button btnnext;
    EditText UserName,Password,Email,PasswordC;
    private FirebaseDatabase databases;
    DatabaseReference ref;
    int maxID= 0;
    Utilisateurs utilisateurs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_guide);

        btnnext=(Button) findViewById(R.id.button_goNext);
        UserName=(EditText) findViewById(R.id.editTexUserName);
        Password=(EditText) findViewById(R.id.editloginPassword);
        Email=(EditText) findViewById(R.id.editTextTextEmail);
        PasswordC=(EditText) findViewById(R.id.editTextTextPasswordC);

        utilisateurs= new  Utilisateurs();
        ref=databases.getInstance().getReference().child("Users");
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        if (snapshot.exists()) {
            int maxId = (int) snapshot.getChildrenCount();
        }else{

            //////
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});


        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString().trim();
                String password = Email.getText().toString().trim();
                String passwordC = PasswordC.getText().toString().trim();
                if (TextUtils.isEmpty(email)){Email.setError(" this is not an email address  Please enter your Email ! ") ; return;}
                if (TextUtils.isEmpty(password)) {Password.setError("Please enter your Password ! ") ; return;}
                if (password.length()<6){Password.setError(" short Password ! ") ; return;}
                if (password!=passwordC ){Password.setError(" you should confirm your Password ! ") ; return;}


          utilisateurs.setUsername(UserName.getText().toString());
          utilisateurs.setPassword(Password.getText().toString());
          utilisateurs.setEmail(Email.getText().toString());

          ref.child(String.valueOf(maxID + 1)).setValue(utilisateurs);

          Toast.makeText(getApplicationContext(), "succeeded In fireBase ", Toast.LENGTH_LONG).show();





                Intent i = new Intent(getApplicationContext(),RegistrationGuide_2.class);
                startActivity(i);
            }
        });
    }

}