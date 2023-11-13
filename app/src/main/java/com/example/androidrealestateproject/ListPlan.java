package com.example.androidrealestateproject;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.androidrealestateproject.dao.PlanDAO;
import com.example.androidrealestateproject.dao.PostDao;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Plan;
import com.example.androidrealestateproject.entity.Post;
import com.example.androidrealestateproject.listServiceProviders.adapterplan;

import java.util.List;

public class ListPlan  extends AppCompatActivity {

    Button btn;
    private TechMasterDataBase database;

    RecyclerView recview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        database = TechMasterDataBase.getRightCleanerDataBase(this);
        setContentView(R.layout.activity_listplan);  // You need to have the "activity_main.xml" layout file
        btn=findViewById(R.id.house1);
        List<Plan> lu = database.planDAO().getAll();
        for(Plan planlist :lu ){
            System.out.println(planlist);
        }


        btn.setOnClickListener(e -> {
            Intent intent = new Intent (this,AddPlan.class);
            startActivity(intent);
        });
        getroomdata();
    }

    public void getroomdata()

    {
        TechMasterDataBase db = Room.databaseBuilder(getApplicationContext(),
                TechMasterDataBase.class, "TechMaster").allowMainThreadQueries().build();
        PlanDAO planDAO = db.planDAO();

        recview1=findViewById(R.id.recview1);
        recview1.setLayoutManager(new LinearLayoutManager(this));

        List<Plan> plan1=planDAO.getAll();

        adapterplan adapter=new adapterplan(plan1);
        recview1.setAdapter(adapter);
    }
}
