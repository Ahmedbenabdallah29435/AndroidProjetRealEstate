package com.example.androidrealestateproject.listServiceProviders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidrealestateproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ServiceReviewViewHolder extends RecyclerView.ViewHolder {
    TextView textReview,textUser;
    public ServiceReviewViewHolder(@NonNull View itemView) {
        super(itemView);
        textReview=itemView.findViewById(R.id.textReview);
        textUser=itemView.findViewById(R.id.textUser);
    }
}
