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

public class SignupActivity extends AppCompatActivity {

    Button signup ;
    EditText email;
    EditText firstName;
    EditText lastName;
    EditText password;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

          signup = findViewById(R.id.SignupBtn);
         email = findViewById(R.id.et_signup_email);
        password = findViewById(R.id.et_signup_pwd);
        firstName = findViewById(R.id.et_fName);
        lastName = findViewById(R.id.et_lName);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Signup();
            }
        });

}

    public void Signup() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        signup =findViewById(R.id.SignupBtn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailId = email.getText().toString();
                String passwordTxt = password.getText().toString();
                String firstNametxt = firstName.getText().toString();
                String lastNameTxt = lastName.getText().toString();

                if (emailId.isEmpty()) {
                    email.setError("Please enter a valid email address");
                    email.requestFocus();
                }else if (firstNametxt.isEmpty()) {
                    firstName.setError("Please enter a valid email address");
                    firstName.requestFocus();
                } else if (lastNameTxt.isEmpty()) {
                    lastName.setError("Please enter a valid password ");
                    lastName.requestFocus();
                }else if (passwordTxt.isEmpty()) {
                    password.setError("Please enter a valid password ");
                    password.requestFocus();
                } else if (!(emailId.isEmpty() && passwordTxt.isEmpty() && firstNametxt.isEmpty() && lastNameTxt.isEmpty())) {
                    mFirebaseAuth.getInstance().createUserWithEmailAndPassword(emailId, passwordTxt).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                TextView errorTxt = findViewById(R.id.errorTxt);
                                errorTxt.setText("User Creation failed");
                                Toast.makeText(SignupActivity.this, "User creation failed", Toast.LENGTH_LONG).show();
                            } else {

                                FirebaseUser mfirebaseUser = mFirebaseAuth.getCurrentUser();
                                if(mfirebaseUser != null) {
                                    mfirebaseUser.getEmail();
                                    Toast.makeText(SignupActivity.this,mfirebaseUser.getEmail().toString(),Toast.LENGTH_LONG).show();
                                    Intent I = new Intent(SignupActivity.this, DashboardActivity.class);
                                    startActivity(I);
                                }

                            }
                        }
                    });
                }


            }
        });


        // FirebaseAuth.signInWithEmailAndPassword();
    }
}
