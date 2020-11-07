package com.dmwm.tunitrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth authentification ;
    Button Sign_in;
    EditText Email,Password;
    ProgressBar  progressBar;
    TextView TextViewSignIn;
    String  email;

    String  password;
       private FirebaseDatabase databases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        authentification=FirebaseAuth.getInstance();
        Email=(EditText) findViewById(R.id.editTextLogintEmailAddress);
        Password=(EditText) findViewById(R.id.editloginPassword);
        TextViewSignIn=(TextView) findViewById(R.id.sign_in);
        Sign_in=(Button)findViewById(R.id.log_in_button);


        Sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email=Email.getText().toString();
                Log.e("here",email);
                password=Password.getText().toString();
                Log.e("heeeeeeeeeeeeeeeeeere",password);
                if (TextUtils.isEmpty(email)){Email.setError("Please enter your Email ! ") ; return;}
                if (TextUtils.isEmpty(password)) {Password.setError("Please enter your Password ! ") ; return;}





                authentification.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"succeed",Toast.LENGTH_LONG ).show();
                        }else { Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG ).show();}

                        }
                    }
                );
            }

















        });
        TextViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Registration_Tourist.class);
                startActivity(i);
            }
        });
    }
}