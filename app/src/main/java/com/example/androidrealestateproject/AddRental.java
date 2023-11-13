package com.example.androidrealestateproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Rental;

public class AddRental extends AppCompatActivity {
    private TechMasterDataBase database;
    Button saveButton;
    EditText title,price,image,description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_addrental);  // You need to have the "activity_main.xml" layout file
        database= TechMasterDataBase.getRightCleanerDataBase(getApplicationContext());
        saveButton=findViewById(R.id.update1);
        title=findViewById(R.id.title3);
        price=findViewById(R.id.price3);
        image=findViewById(R.id.image3);
        description=findViewById(R.id.description3);

        saveButton.setOnClickListener(v -> {
            Rental rental = new Rental();
            rental.setTitle(title.getText().toString());
            rental.setPicture(image.getText().toString());

            String pri= price.getText().toString();
            Double price=Double.parseDouble(pri);
            rental.setMonthlyrent(price);


            rental.setDescription(description.getText().toString());


            database.rentalDAO().addRental(rental);

            Intent intent = new Intent (this,ListRental.class);
            startActivity(intent);

        });


    }
}