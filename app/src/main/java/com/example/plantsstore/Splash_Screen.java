package com.example.plantsstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Splash_Screen extends AppCompatActivity {

    FirebaseAuth auth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                boolean check = preferences.getBoolean("open", false);

                Intent intent;
                if (check) {
                    intent = new Intent(Splash_Screen.this, Home_Activity4.class);
                } else {
                    intent = new Intent(Splash_Screen.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },3000);
    }
}