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
import com.example.androidrealestateproject.dao.PostDao;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Post;
import com.example.androidrealestateproject.updatedata1;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class myadapter1 extends RecyclerView.Adapter<myadapter1.myviewholder>
{
    List<Post> users;

    public myadapter1(List<Post> users) {
        this.users = users;
    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign1,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myviewholder holder, @SuppressLint("RecyclerView") int position) {
          holder.recid.setText(String.valueOf(users.get(position).getPostid()));
          holder.recfname.setText(users.get(position).getTitle());



        holder.reclname.setText(users.get(position).getPostContent());


          holder.edbtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(new Intent(holder.edbtn.getContext(), updatedata1.class));
                  intent.putExtra("uid",String.valueOf(users.get(position).getPostid()));
                  intent.putExtra("ufname",users.get(position).getTitle());
                  intent.putExtra("ulname",users.get(position).getPostContent());
                  holder.edbtn.getContext().startActivity(intent);
              }
          });


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
       {

           TextView recid,recfname, reclname , reclname1 ,recfname1;
           ImageButton edbtn;
           public myviewholder(@NonNull @NotNull View itemView) {
               super(itemView);

               recid=itemView.findViewById(R.id.recid);
               recfname=itemView.findViewById(R.id.recfname);
               reclname=itemView.findViewById(R.id.reclname);

               edbtn=itemView.findViewById(R.id.edbtn);
           }
       }
}
