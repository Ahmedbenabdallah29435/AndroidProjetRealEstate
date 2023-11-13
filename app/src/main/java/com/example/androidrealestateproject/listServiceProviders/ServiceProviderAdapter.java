package com.example.androidrealestateproject.listServiceProviders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidrealestateproject.R;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.UserServiceProvider;
import com.example.androidrealestateproject.helper.SessionManagement;

import java.util.List;

public class ServiceProviderAdapter extends RecyclerView.Adapter<ServiceProviderViewHolder> {
    List<UserServiceProvider> serviceProviderList;
    SessionManagement sessionManagement;
    public ServiceProviderAdapter(Context context){
        TechMasterDataBase techMasterDataBase = TechMasterDataBase.getRightCleanerDataBase(context);
        sessionManagement=new SessionManagement(context);
        serviceProviderList= techMasterDataBase.userServiceProviderDAO().getByService(sessionManagement.getServiceChoice().get("service_choice").toString());


    }


    @NonNull
    @Override
    public ServiceProviderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ServiceProviderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceProviderViewHolder holder, int position) {
    UserServiceProvider provider=serviceProviderList.get(position);
    holder.thead.setText(provider.getUsername());
    holder.tService.setText(provider.getService());
    holder.tprice.setText(provider.getPrice());
    holder.details.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //go details

        }
    });
    }

    @Override
    public int getItemCount() {
        return serviceProviderList.size();
    }
}
