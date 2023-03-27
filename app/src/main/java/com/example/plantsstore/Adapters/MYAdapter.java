package com.example.plantsstore.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantsstore.Modals.Modal1;
import com.example.plantsstore.R;
import com.example.plantsstore.ViewHolders.ViewHolder1;

import java.util.ArrayList;
import java.util.List;

public class MYAdapter extends RecyclerView.Adapter<ViewHolder1> {
    ArrayList<Modal1> list;
    public MYAdapter(ArrayList<Modal1> list) {
        this.list = list;
    }

    public void setFilteredlist(ArrayList<Modal1> filteredlist ){
        this.list = filteredlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singlerow_plantscard, parent, false);

        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 holder, int position) {

        holder.t1image.setImageResource(list.get(position).getP_image());
        holder.t2p_name.setText(list.get(position).getP_name());
        holder.t3price.setText(list.get(position).getP_price());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
