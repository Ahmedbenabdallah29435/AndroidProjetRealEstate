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
import com.example.androidrealestateproject.UpdateRental;

import com.example.androidrealestateproject.dao.RentalDAO;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Rental;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class adaptaterrental extends RecyclerView.Adapter<adaptaterrental.myviewholder>{

    List<Rental> rentals;

    public adaptaterrental(List<Rental> rentals) {
        this.rentals = rentals;
    }

    @NonNull
    @NotNull
    @Override
    public adaptaterrental.myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new adaptaterrental.myviewholder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull @NotNull adaptaterrental.myviewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.recfname.setText(rentals.get(position).getTitle());
        holder.recid.setText(String.valueOf(rentals.get(position).getMonthlyrent()));


        holder.reclname.setText(rentals.get(position).getDescription());
        holder.delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TechMasterDataBase db = Room.databaseBuilder(holder.recid.getContext(),
                        TechMasterDataBase.class, "TechMaster").allowMainThreadQueries().build();
                RentalDAO rentalDAO = db.rentalDAO();
                // this is to delete the record from room database
            rentalDAO.deleteById(rentals.get(position).getOffreid());
            int test=rentals.get(position).getOffreid();
            System.out.println(test + "*********");
                // this is to delete the record from Array List which is the source of recview data
                rentals.remove(position);

                //update the fresh list of ArrayList data to recview
                notifyDataSetChanged();
            }
        });
        holder.edbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(new Intent(holder.edbtn.getContext(), UpdateRental.class));
                intent.putExtra("id",String.valueOf(rentals.get(position).getOffreid()));
                intent.putExtra("title",rentals.get(position).getTitle());
                intent.putExtra("price",String.valueOf(rentals.get(position).getMonthlyrent()));
                intent.putExtra("image",rentals.get(position).getPicture());
                intent.putExtra("description",rentals.get(position).getDescription());
                holder.edbtn.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return rentals.size();
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
