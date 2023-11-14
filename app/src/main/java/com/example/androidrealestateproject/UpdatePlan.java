package com.example.androidrealestateproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import com.example.androidrealestateproject.SmsUtils;

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

        title=findViewById(R.id.title1);
        price=findViewById(R.id.price1);
        livingroom=findViewById(R.id.livingroom1);
        kitchen=findViewById(R.id.kitchen1);
        wc=findViewById(R.id.wc1);
        room=findViewById(R.id.room1);
        image=findViewById(R.id.image1);
        description=findViewById(R.id.description1);
        saveButton=findViewById(R.id.update);


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

                // Send SMS after updating the plan
                String phoneNumber = "+21623402479"; // Replace with the actual phone number
                String message = "Bonjour, c'est un exemple de message SMS.";
                SmsUtils.sendSms(UpdatePlan.this, phoneNumber, message);

                startActivity(new Intent(getApplicationContext(),ListPlan.class));
                finish();

            }





        });

    }


}
