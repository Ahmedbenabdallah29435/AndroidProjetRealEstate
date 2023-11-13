package com.example.androidrealestateproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.androidrealestateproject.dao.PostDao;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Post;
import com.example.androidrealestateproject.listServiceProviders.myadapter;

import java.util.List;

public class fetchdata extends AppCompatActivity
{
   RecyclerView recview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata);

        getroomdata();
    }

    public void getroomdata()
    {
        TechMasterDataBase db = Room.databaseBuilder(getApplicationContext(),
                TechMasterDataBase.class, "TechMaster").allowMainThreadQueries().build();
        PostDao postDao = db.postDAO();

        recview=findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        List<Post> post1=postDao.getallposts();

        myadapter adapter=new myadapter(post1);
        recview.setAdapter(adapter);
    }
}