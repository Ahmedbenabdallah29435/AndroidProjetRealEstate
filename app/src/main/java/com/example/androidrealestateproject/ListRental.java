package com.example.androidrealestateproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.androidrealestateproject.dao.PlanDAO;
import com.example.androidrealestateproject.dao.RentalDAO;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Plan;
import com.example.androidrealestateproject.entity.Rental;
import com.example.androidrealestateproject.listServiceProviders.adaptaterrental;

import java.util.List;

public class ListRental extends AppCompatActivity {
    Button btn;
    private TechMasterDataBase database;

    RecyclerView recview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        database = TechMasterDataBase.getRightCleanerDataBase(this);
        setContentView(R.layout.activity_listrental);  // You need to have the "activity_main.xml" layout file
        btn=findViewById(R.id.house2);
        List<Rental> lu = database.rentalDAO().getAll();
        for(Rental rentallist :lu ){
            System.out.println(rentallist);
        }


        btn.setOnClickListener(e -> {
            Intent intent = new Intent (this,AddRental.class);
            startActivity(intent);
        });
        getroomdata();
    }

    public void getroomdata()

    {
        TechMasterDataBase db = Room.databaseBuilder(getApplicationContext(),
                TechMasterDataBase.class, "TechMaster").allowMainThreadQueries().build();
        RentalDAO rentalDAO = db.rentalDAO();

        recview2=findViewById(R.id.recview2);
        recview2.setLayoutManager(new LinearLayoutManager(this));

        List<Rental> rental1=rentalDAO.getAll();

         adaptaterrental adaptaterrental=new adaptaterrental(rental1);
        recview2.setAdapter(adaptaterrental);
    }
}
