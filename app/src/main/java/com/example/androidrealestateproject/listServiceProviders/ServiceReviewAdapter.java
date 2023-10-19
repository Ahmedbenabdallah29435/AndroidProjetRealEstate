package com.example.androidrealestateproject.listServiceProviders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidrealestateproject.R;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Review;
import com.example.androidrealestateproject.helper.SessionManagement;

import java.util.List;

public class ServiceReviewAdapter extends RecyclerView.Adapter<ServiceReviewViewHolder> {
    List<Review> serviceReviewList;
    SessionManagement sessionManagement;

    public ServiceReviewAdapter(Context context) {
        TechMasterDataBase techMasterDataBase = TechMasterDataBase.getRightCleanerDataBase(context);
        sessionManagement = new SessionManagement(context);
        serviceReviewList = techMasterDataBase.reviewDAO().getReviewByEmailServiceUser(sessionManagement.getProfile().get("profile").toString());


    }


    @NonNull
    @Override
    public ServiceReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_review,parent,false);
        return new ServiceReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceReviewViewHolder holder, int position) {
        Review review=serviceReviewList.get(position);
        holder.textReview.setText(review.getReview());
        holder.textUser.setText(review.getEmailSimpleUser());
    }

    @Override
    public int getItemCount() {
        return serviceReviewList.size();
    }
}


