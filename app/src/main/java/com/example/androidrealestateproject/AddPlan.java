package com.example.androidrealestateproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Plan;

public class AddPlan extends AppCompatActivity {
    private TechMasterDataBase database;
    Button saveButton;
    EditText title,price,livingroom,kitchen,wc,room,image,description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplan);  // You need to have the "activity_main.xml" layout file
        database= TechMasterDataBase.getRightCleanerDataBase(getApplicationContext());
        saveButton=findViewById(R.id.update);
        title=findViewById(R.id.title1);
        price=findViewById(R.id.price1);
        livingroom=findViewById(R.id.livingroom1);
        kitchen=findViewById(R.id.kitchen1);
        wc=findViewById(R.id.wc1);
        room=findViewById(R.id.room1);
        image=findViewById(R.id.image1);
        description=findViewById(R.id.description1);

        saveButton.setOnClickListener(v -> {
            Plan plan = new Plan();
            plan.setTitle(title.getText().toString());
            plan.setPicture(image.getText().toString());

            String pri= price.getText().toString();
            Double price=Double.parseDouble(pri);
            plan.setPrice(price);


            String value= livingroom.getText().toString();
            int finalValue=Integer.parseInt(value);
            plan.setLivingroom(finalValue);

            String ki= livingroom.getText().toString();
            int kitchen=Integer.parseInt(ki);
            plan.setKitchen(kitchen);

            String wcc= wc.getText().toString();
            int wc=Integer.parseInt(wcc);
            plan.setWc(wc);

            String roo= room.getText().toString();
            int room=Integer.parseInt(roo);
            plan.setRoom1(room);


            plan.setDescription(description.getText().toString());


            database.planDAO().addPlan(plan);

            Intent intent = new Intent (this,ListPlan.class);
            startActivity(intent);

        });


    }
}
