package com.example.plantsstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.plantsstore.fragments.cartFragment;
import com.example.plantsstore.fragments.favouritesFragment;
import com.example.plantsstore.fragments.home_Fragment;
import com.example.plantsstore.fragments.profileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class    Home_Activity4 extends AppCompatActivity {

    BottomNavigationView bottomNaview;
    FrameLayout viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home4);

        viewPager = findViewById(R.id.framelayout_id);
        bottomNaview = findViewById(R.id.navigationV_id);


        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new home_Fragment()).commit();

        bottomNaview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home_id:
                        fragment = new home_Fragment();
                        break;
                    case R.id.favourite_id:
                        fragment = new favouritesFragment();
                        break;
                    case R.id.cart_id:
                        fragment = new cartFragment();
                        break;
                    case R.id.profile_id:
                        fragment = new profileFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, fragment).commit();
                return true;
            }
        });
    }
}