package com.example.androidrealestateproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.androidrealestateproject.dao.PlanDAO;
import com.example.androidrealestateproject.dao.RentalDAO;
import com.example.androidrealestateproject.database.TechMasterDataBase;

public class UpdateRental extends AppCompatActivity {

    int id;
    EditText title,price,image,description;
    private TechMasterDataBase database;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updaterental);

        title=findViewById(R.id.title3);
        price=findViewById(R.id.price3);

        image=findViewById(R.id.image3);
        description=findViewById(R.id.description3);
        saveButton=findViewById(R.id.update1);


        id=Integer.parseInt(getIntent().getStringExtra("id"));
        title.setText(getIntent().getStringExtra("title"));
        price.setText(getIntent().getStringExtra("price"));

        image.setText(getIntent().getStringExtra("image"));
        description.setText(getIntent().getStringExtra("description"));


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TechMasterDataBase db = Room.databaseBuilder(getApplicationContext(),
                        TechMasterDataBase.class, "TechMaster").allowMainThreadQueries().build();
                RentalDAO rentalDAO = db.rentalDAO();


                rentalDAO.updateById(id,title.getText().toString(),Double.parseDouble(price.getText().toString()),
                        image.getText().toString(),description.getText().toString());
                startActivity(new Intent(getApplicationContext(),ListRental.class));
                finish();
            }

        });
    }

}
