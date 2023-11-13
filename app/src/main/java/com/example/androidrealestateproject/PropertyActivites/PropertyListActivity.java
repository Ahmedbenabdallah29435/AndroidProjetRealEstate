package com.example.androidrealestateproject.PropertyActivites;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.androidrealestateproject.R;
import com.example.androidrealestateproject.adapters.PropertyAdapter;
import com.example.androidrealestateproject.database.RightCleanerDataBase;
import com.example.androidrealestateproject.entity.Property;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class PropertyListActivity extends AppCompatActivity implements PropertyAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private PropertyAdapter propertyAdapter;
    private RightCleanerDataBase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_list);

        recyclerView = findViewById(R.id.recyclerViewProperties);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        appDatabase = RightCleanerDataBase.getRightCleanerDataBase(this);

        FloatingActionButton fabAddProperty = findViewById(R.id.fabAddProperty);
        fabAddProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PropertyListActivity.this, AddPropertyActivity.class));
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Properties");
        setSupportActionBar(toolbar);



        loadProperties();
    }

    private void loadProperties() {
        new LoadPropertiesTask().execute();
    }

    private class LoadPropertiesTask extends AsyncTask<Void, Void, List<Property>> {
        @Override
        protected List<Property> doInBackground(Void... voids) {
            return appDatabase.propertyDao().getAllProperties();
        }

        @Override
        protected void onPostExecute(List<Property> properties) {
            propertyAdapter = new PropertyAdapter(properties, PropertyListActivity.this);
            recyclerView.setAdapter(propertyAdapter);
        }
    }

    @Override
    public void onItemClick(Property property) {
        String propertyJson = new Gson().toJson(property);
        Intent intent = new Intent(this, PropertyDetailsActivity.class);
        intent.putExtra("property", propertyJson);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_property_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuUserProperties) {
            startActivity(new Intent(this, UserPropertiesActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

