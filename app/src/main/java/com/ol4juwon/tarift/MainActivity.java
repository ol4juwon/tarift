package com.ol4juwon.tarift;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


    }

    public void login(String email,String password
    ){
        FirebaseAuth mfireb = new FirebaseAuth.getInstance();
        FirebaseAuth.signInWithEmailAndPassword()

    }
}