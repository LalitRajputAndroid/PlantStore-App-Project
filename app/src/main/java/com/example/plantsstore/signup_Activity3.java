package com.example.plantsstore;

import  androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;

import android.widget.Toast;

import com.example.plantsstore.Modals.Users;
import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signup_Activity3 extends AppCompatActivity {

    MaterialButton signup_btn;
    TextInputEditText full_name, email_id, signup_password, confirm_password;
    MaterialTextView login_text;
    String EV = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+";

    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3);

        login_text = findViewById(R.id.login_text_id);
        signup_btn = findViewById(R.id.signup_btn_id);
        full_name = findViewById(R.id.fullname_id);
        email_id = findViewById(R.id.email_id);
        signup_password = findViewById(R.id.signuppassword_id);
        confirm_password = findViewById(R.id.confirmpassword_id);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressBar = new ProgressDialog(this);
        progressBar.setTitle("Creating Account");
        progressBar.setMessage("We`re Creating Your Account");
        progressBar.setCanceledOnTouchOutside(false);


        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkdetails();
            }
        });

        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup_Activity3.this, login_Activity2.class));
            }
        });
    }

    private void checkdetails() {

        String name = full_name.getText().toString();
        String email = email_id.getText().toString();
        String pass = signup_password.getText().toString();
        String c_pass = confirm_password.getText().toString();

        if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            full_name.setError("");
            email_id.setError("");
            signup_password.setError("");
            Toast.makeText(signup_Activity3.this, "Fell the feild", Toast.LENGTH_SHORT).show();

        } else if (!email.matches(EV)) {
            Toast.makeText(this, "Email is not Valid ", Toast.LENGTH_SHORT).show();
        } else if (pass.length() <= 8) {
            Toast.makeText(this, "Password must be 8 character", Toast.LENGTH_SHORT).show();
        } else if (!pass.equals(c_pass)) {
            Toast.makeText(this, "Password not match!", Toast.LENGTH_SHORT).show();
        } else {
            progressBar.show();
            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressBar.dismiss();
                    if (task.isSuccessful()) {
                        String id = task.getResult().getUser().getUid();

                        Users users = new Users(name,email,pass,id);

                        database.getReference().child("User").child(id).setValue(users);
                        SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("open", true);
                        editor.apply();

                        Toast.makeText(signup_Activity3.this, "Succesfully Registration", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signup_Activity3.this, Home_Activity4.class));
                        finish();
                    } else {
                        progressBar.dismiss();
                        Toast.makeText(signup_Activity3.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}