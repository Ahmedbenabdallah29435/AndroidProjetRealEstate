package com.example.androidrealestateproject.listServiceProviders;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.androidrealestateproject.R;
import com.example.androidrealestateproject.UpdatePlan;
import com.example.androidrealestateproject.dao.PostDao;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Plan;
import com.example.androidrealestateproject.updatedata;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class adapterplan extends RecyclerView.Adapter<adapterplan.myviewholder>{
    List<Plan> plans;

    public adapterplan(List<Plan> users) {
        this.plans = users;
    }

    @NonNull
    @NotNull
    @Override
    public  myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new adapterplan.myviewholder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull @NotNull adapterplan.myviewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.recfname.setText(plans.get(position).getTitle());
        holder.recid.setText(String.valueOf(plans.get(position).getPrice()));


        holder.reclname.setText(plans.get(position).getDescription());
        holder.delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TechMasterDataBase db = Room.databaseBuilder(holder.recid.getContext(),
                        TechMasterDataBase.class, "TechMaster").allowMainThreadQueries().build();
                PostDao userDao = db.postDAO();
                // this is to delete the record from room database
                userDao.deleteById(plans.get(position).getPlanid());
                // this is to delete the record from Array List which is the source of recview data
                plans.remove(position);

                //update the fresh list of ArrayList data to recview
                notifyDataSetChanged();
            }
        });
        holder.edbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(new Intent(holder.edbtn.getContext(), UpdatePlan.class));
                intent.putExtra("id",String.valueOf(plans.get(position).getPlanid()));
                intent.putExtra("title",plans.get(position).getTitle());
                intent.putExtra("livingroom",String.valueOf(plans.get(position).getLivingroom()));
                intent.putExtra("kitchen",String.valueOf(plans.get(position).getKitchen()));
                intent.putExtra("price",String.valueOf(plans.get(position).getPrice()));
                intent.putExtra("room1",String.valueOf(plans.get(position).getRoom1()));
                intent.putExtra("image",plans.get(position).getPicture());
                intent.putExtra("wc",String.valueOf(plans.get(position).getWc()));
                intent.putExtra("description",plans.get(position).getDescription());
                holder.edbtn.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {

        TextView recid,recfname, reclname , reclname1 ,recfname1;
        ImageButton delbtn,edbtn;
        public myviewholder(@NonNull @NotNull View itemView) {
            super(itemView);

            recid=itemView.findViewById(R.id.recid);
            recfname=itemView.findViewById(R.id.recfname);
            reclname=itemView.findViewById(R.id.reclname);
            delbtn=itemView.findViewById(R.id.delbtn);
            edbtn=itemView.findViewById(R.id.edbtn);
        }
    }

}
