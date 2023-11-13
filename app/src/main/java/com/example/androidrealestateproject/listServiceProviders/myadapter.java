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
import com.example.androidrealestateproject.updatedata;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    List<Post> users;

    public myadapter(List<Post> users) {
        this.users = users;
    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myviewholder holder, @SuppressLint("RecyclerView") int position) {
          holder.recid.setText(String.valueOf(users.get(position).getPostid()));
          holder.recfname.setText(users.get(position).getTitle());



        holder.reclname.setText(users.get(position).getPostContent());
          holder.delbtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  TechMasterDataBase db = Room.databaseBuilder(holder.recid.getContext(),
                          TechMasterDataBase.class, "TechMaster").allowMainThreadQueries().build();
                  PostDao userDao = db.postDAO();
                  // this is to delete the record from room database
                  userDao.deleteById(users.get(position).getPostid());
                  // this is to delete the record from Array List which is the source of recview data
                  users.remove(position);

                  //update the fresh list of ArrayList data to recview
                  notifyDataSetChanged();
              }
          });
          holder.edbtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(new Intent(holder.edbtn.getContext(), updatedata.class));
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
