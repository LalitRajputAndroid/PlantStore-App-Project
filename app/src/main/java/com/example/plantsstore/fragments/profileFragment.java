package com.example.plantsstore.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.plantsstore.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class profileFragment extends Fragment {

    MaterialButton logoutbtn;

    public profileFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        logoutbtn = view.findViewById(R.id.logoutbtn_id);

        logoutbtn.setOnClickListener(v -> {
            SharedPreferences preferences = requireActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("open",false);
            editor.apply();

            FirebaseAuth.getInstance().signOut();
        });

        return view;
    }
}