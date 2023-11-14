package com.example.androidrealestateproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



import com.example.androidrealestateproject.PropertyActivites.PropertyListActivity;

import com.example.androidrealestateproject.dao.ReviewDAO;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.androidrealestateproject.dao.UserDAO;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.helper.ServiceCategory;
import com.example.androidrealestateproject.helper.SessionManagement;


public class ServiceChoice extends AppCompatActivity {

    Button btnHouseCleaning,btnGarden,btnElec,btnBlog;
    TechMasterDataBase techMasterDataBase;

    UserDAO userDAO;
    SessionManagement sessionManagement;
    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_service_page);
        btnElec=findViewById(R.id.ElectricianBtn);
        btnHouseCleaning=findViewById(R.id.HouseCleaningBtn);
        btnGarden=findViewById(R.id.GardenerBtn);

        btnBlog=findViewById(R.id.HouseCleaningBtn1);

        btnProperties=findViewById(R.id.PropertiesBtn);


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sessionManagement=new SessionManagement(getApplicationContext());
        techMasterDataBase = TechMasterDataBase.getRightCleanerDataBase(getApplicationContext());
        userDAO= techMasterDataBase.userDAO();

        btnElec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sessionManagement.setServiceChoiceSession(ServiceCategory.RENTAL.toString());
                Intent intent = new Intent(ServiceChoice.this, PropertyListActivity.class);
                startActivity(intent);
            }
        });
        btnGarden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManagement.setServiceChoiceSession(ServiceCategory.RENTAL.toString());
                Intent intent = new Intent(ServiceChoice.this, ListRental.class);
                startActivity(intent);
            }
        });
        btnHouseCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManagement.setServiceChoiceSession(ServiceCategory.CONSTRUCTOR.toString());
                Intent intent = new Intent(ServiceChoice.this, ListPlan.class);
                startActivity(intent);
            }
        });
        btnBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManagement.setServiceChoiceSession(ServiceCategory.BLOGGER.toString());
                Intent intent = new Intent(ServiceChoice.this, test.class);
                startActivity(intent);
            }
        });

     

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SessionManagement sessionManagement = new SessionManagement(getApplicationContext());
        switch (item.getItemId()) {
            case R.id.homeP: {
                startActivity(new Intent(this,ServiceChoice.class));
                break;
            }
            case R.id.profileP:{
                startActivity(new Intent(this,ProfilePage.class));
                break;
            }
            case  R.id.logOut:{
                sessionManagement.logoutUser();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!sessionManagement.isLoggedIn()) {
            sendToLoginPage();
        }
    }
    public void sendToLoginPage(){
        startActivity(new Intent(this,MainActivity.class));

    }









}
