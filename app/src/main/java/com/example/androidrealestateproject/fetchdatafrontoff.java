package com.example.androidrealestateproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.androidrealestateproject.dao.PostDao;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Post;
import com.example.androidrealestateproject.listServiceProviders.myadapter1;

import java.util.List;

public class fetchdatafrontoff extends AppCompatActivity {
    RecyclerView recview;
    Button b88;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata1);

        // Initialize your button after setting the content view
        b88 = findViewById(R.id.b88);

        // Call the method to set up RecyclerView
        getroomdata();

        // Set OnClickListener for the button
        b88.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ServiceChoice2.class));
            }
        });
    }

    public void getroomdata() {
        TechMasterDataBase db = Room.databaseBuilder(getApplicationContext(),
                TechMasterDataBase.class, "TechMaster").allowMainThreadQueries().build();
        PostDao postDao = db.postDAO();

        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        List<Post> post1 = postDao.getallposts();

        myadapter1 adapter = new myadapter1(post1);
        recview.setAdapter(adapter);
    }
}
