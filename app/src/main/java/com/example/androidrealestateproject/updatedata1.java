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

public class updatedata1 extends AppCompatActivity
{
  int id;
  EditText name, content;
  Button b155;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata1);

        name=findViewById(R.id.editfname);
        content=findViewById(R.id.editlname);
        b155=findViewById(R.id.b155);
        id=Integer.parseInt(getIntent().getStringExtra("uid"));
        name.setText(getIntent().getStringExtra("ufname"));
        content.setText(getIntent().getStringExtra("ulname"));


        b155.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), fetchdatafrontoff.class));
            }
        });
    }




}