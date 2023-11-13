package com.example.androidrealestateproject.PropertyActivites;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidrealestateproject.R;
import com.example.androidrealestateproject.adapters.PropertyAdapter;
import com.example.androidrealestateproject.database.RightCleanerDataBase;
import com.example.androidrealestateproject.entity.Property;
import com.example.androidrealestateproject.helper.SessionManagement;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class UserPropertiesActivity extends AppCompatActivity implements PropertyAdapter.OnItemClickListener{

    private RightCleanerDataBase appDatabase;
    private SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_properties);

        appDatabase = RightCleanerDataBase.getRightCleanerDataBase(this);
        session = new SessionManagement(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("User Properties");

        displayUserProperties();
    }

    private void displayUserProperties() {
        HashMap<String, Object> userDetails = session.getUserDetails();
        int userId = (int) userDetails.get(SessionManagement.KEY_ID);
        List<Property> userProperties = appDatabase.propertyDao().getPropertiesByUserId(userId);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewUserProperties);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PropertyAdapter propertyAdapter = new PropertyAdapter(userProperties,UserPropertiesActivity.this);
        recyclerView.setAdapter(propertyAdapter);
    }



    @Override
    public void onItemClick(Property property) {
        String propertyJson = new Gson().toJson(property);
        Intent intent = new Intent(this, UserPropertyDetailsActivity.class);
        intent.putExtra("property", propertyJson);
        startActivity(intent);
    }

}

