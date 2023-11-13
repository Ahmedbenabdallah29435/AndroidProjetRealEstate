package com.example.androidrealestateproject.listServiceProviders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidrealestateproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ServiceProviderViewHolder extends RecyclerView.ViewHolder {
    TextView thead,tService,tprice;
    FloatingActionButton details;
    public ServiceProviderViewHolder(@NonNull View itemView) {
        super(itemView);
        thead=itemView.findViewById(R.id.tvHeading);
        tService=itemView.findViewById(R.id.tService);
        tprice=itemView.findViewById(R.id.tprice);
        details=itemView.findViewById(R.id.details);
    }
}
