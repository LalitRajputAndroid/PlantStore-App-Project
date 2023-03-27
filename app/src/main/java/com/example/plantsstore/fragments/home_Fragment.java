package com.example.plantsstore.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantsstore.Adapters.MYAdapter;
import com.example.plantsstore.Modals.Modal1;
import com.example.plantsstore.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class home_Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView recyclerView;
    SearchView searchView ;
    FirebaseAuth auth ;
    FirebaseDatabase database;
    MYAdapter myAdapter ;

    public home_Fragment() {
    }

    public static home_Fragment newInstance(String param1, String param2) {
        home_Fragment fragment = new home_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("CutPasteId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_, container, false);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        recyclerView = view.findViewById(R.id.recyclerview_id);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));

        ArrayList<Modal1> list =new ArrayList<>();

        myAdapter = new MYAdapter(list);

        searchView = view.findViewById(R.id.searchView_id);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterlist(newText);
                return true;
            }

            private void filterlist(String Text) {
                ArrayList<Modal1> filteredlist = new ArrayList<>();
                for (Modal1 modal1 : list){
                    if (modal1.getP_name().toLowerCase().contains(Text.toLowerCase())){
                        filteredlist.add(modal1);
                    }
                }
                if (filteredlist.isEmpty()){
                    Toast.makeText(view.getContext(), "No data found", Toast.LENGTH_SHORT).show();
                }else {
                    myAdapter.setFilteredlist(filteredlist);
                }
            }
        });

        return view;
    }
}