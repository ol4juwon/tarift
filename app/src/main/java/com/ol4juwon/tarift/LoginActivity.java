package com.ol4juwon.tarift;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    EditText email ;
     EditText password;
    Button login ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        Button logonBtn = findViewById(R.id.loginbtn);
        logonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();


              //  Toast.makeText(LoginActivity.this,"Login clicked",Toast.LENGTH_LONG).show();
            }
        });


    }

    public void login(){
        email = findViewById(R.id.ETemail);
        password = findViewById(R.id.ETpassword);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(  mFirebaseUser != null  ){

                    Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(i);

                }else{

                }
            }
        };

                String emailId  = email.getText().toString();
                String passwordTxt  = password.getText().toString();

                if(emailId.isEmpty()){
                    email.setError("Please enter a valid email address");
                    email.requestFocus();
                }else if(passwordTxt.isEmpty()){
                    password.setError("Please enter a valid password ");
                    password.requestFocus();
                }else if(!(emailId.isEmpty() && passwordTxt.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(emailId,passwordTxt).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                TextView errorTxt = findViewById(R.id.errorTxt);
                                errorTxt.setText("Login failed");
                                Toast.makeText(LoginActivity.this,"User Login failed",Toast.LENGTH_LONG).show();
                            }else{

                                Intent I = new Intent(LoginActivity.this, DashboardActivity.class);
                                startActivity(I);

                            }
                        }
                    });
                }




    }

    public void Signup(){
         mFirebaseAuth =  FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailId  = email.getText().toString();
                String passwordTxt  = password.getText().toString();

                if(emailId.isEmpty()){
                    email.setError("Please enter a valid email address");
                    email.requestFocus();
                }else if(passwordTxt.isEmpty()){
                    password.setError("Please enter a valid password ");
                    password.requestFocus();
                }else if(!(emailId.isEmpty() && passwordTxt.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(emailId,passwordTxt).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                TextView errorTxt = findViewById(R.id.errorTxt);
                                errorTxt.setText("User Creation failed");
                                Toast.makeText(LoginActivity.this,"User creation failed",Toast.LENGTH_LONG).show();
                            }else{

                                Intent I = new Intent(LoginActivity.this, DashboardActivity.class);
                                startActivity(I);

                            }
                        }
                    });
                }


            }
        });


        // FirebaseAuth.signInWithEmailAndPassword();


    }
}