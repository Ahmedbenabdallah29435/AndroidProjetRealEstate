package com.example.androidrealestateproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.androidrealestateproject.dao.PlanDAO;
import com.example.androidrealestateproject.database.TechMasterDataBase;

public class UpdatePlan extends AppCompatActivity {

    int id;
    EditText title,price,livingroom,kitchen,wc,room,image,description;
    private TechMasterDataBase database;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateplan);

        title=findViewById(R.id.title3);
        price=findViewById(R.id.price3);
        livingroom=findViewById(R.id.livingroom1);
        kitchen=findViewById(R.id.kitchen1);
        wc=findViewById(R.id.wc1);
        room=findViewById(R.id.room1);
        image=findViewById(R.id.image3);
        description=findViewById(R.id.description3);
        saveButton=findViewById(R.id.update1);


        id=Integer.parseInt(getIntent().getStringExtra("id"));
        title.setText(getIntent().getStringExtra("title"));
        price.setText(getIntent().getStringExtra("price"));
        livingroom.setText(getIntent().getStringExtra("livingroom"));
        kitchen.setText(getIntent().getStringExtra("kitchen"));
        wc.setText(getIntent().getStringExtra("wc"));
        room.setText(getIntent().getStringExtra("room1"));
        image.setText(getIntent().getStringExtra("image"));
        description.setText(getIntent().getStringExtra("description"));


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TechMasterDataBase db = Room.databaseBuilder(getApplicationContext(),
                        TechMasterDataBase.class, "TechMaster").allowMainThreadQueries().build();
                PlanDAO planDAO = db.planDAO();


                planDAO.updateById(id,title.getText().toString(),Double.parseDouble(price.getText().toString()),
                        Integer.parseInt (livingroom.getText().toString()),Integer.parseInt (kitchen.getText().toString()),
                        Integer.parseInt (wc.getText().toString()),Integer.parseInt (room.getText().toString()),
                        image.getText().toString(),description.getText().toString());
                startActivity(new Intent(getApplicationContext(),ListPlan.class));
                finish();
            }

        });
    }

}
