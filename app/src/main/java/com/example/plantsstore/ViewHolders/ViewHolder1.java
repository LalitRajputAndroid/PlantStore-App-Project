package com.example.plantsstore.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantsstore.R;

public class ViewHolder1 extends RecyclerView.ViewHolder {

    public ImageView t1image;
    public TextView t2p_name;
    public TextView t3price;

    public ViewHolder1(@NonNull View itemView) {
        super(itemView);

        t1image = itemView.findViewById(R.id.t1img_id);
        t2p_name = itemView.findViewById(R.id.t2name_id);
        t3price = itemView.findViewById(R.id.t3price_id);

    }
}
