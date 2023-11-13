package com.example.androidrealestateproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.androidrealestateproject.dao.PostDao;
import com.example.androidrealestateproject.database.TechMasterDataBase;

public class updatedata extends AppCompatActivity
{
  int id;
  EditText name, content;
  Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);

        name=findViewById(R.id.editfname);
        content=findViewById(R.id.editlname);
        btn=findViewById(R.id.btn);

        id=Integer.parseInt(getIntent().getStringExtra("uid"));
        name.setText(getIntent().getStringExtra("ufname"));
        content.setText(getIntent().getStringExtra("ulname"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TechMasterDataBase db = Room.databaseBuilder(getApplicationContext(),
                        TechMasterDataBase.class, "TechMaster").allowMainThreadQueries().build();
                PostDao postDao = db.postDAO();
                postDao.updateById(id,name.getText().toString(),content.getText().toString());//
                startActivity(new Intent(getApplicationContext(),fetchdata.class));
                finish();
            }
        });
    }




}