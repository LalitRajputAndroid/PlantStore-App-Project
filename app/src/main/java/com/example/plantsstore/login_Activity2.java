package com.example.plantsstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_Activity2 extends AppCompatActivity {

    MaterialButton loginbtn;
    TextInputEditText login_email, Password;
    MaterialTextView signuptextclick;
    ProgressDialog progressDialog;

    FirebaseAuth auth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        loginbtn = findViewById(R.id.loginbutton_id);
        login_email = findViewById(R.id.login_email_id);
        Password = findViewById(R.id.login_password_id);
        signuptextclick = findViewById(R.id.signupclick_id);

        auth = FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Login to your account");
        progressDialog.setCanceledOnTouchOutside(false);



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checklogindetail();
            }
        });

        signuptextclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_Activity2.this, signup_Activity3.class));
            }
        });

    }

    private void checklogindetail(){

        String lo_email = login_email.getText().toString();
        String lo_pass = Password.getText().toString();
        progressDialog.show();
        auth.signInWithEmailAndPassword(lo_email,lo_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressDialog.dismiss();
                    SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("open", true);
                    editor.apply();
                    startActivity(new Intent(login_Activity2.this, Home_Activity4.class));
                    finish();
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(login_Activity2.this, "Invalid Email and Password", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(login_Activity2.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}