package com.example.androidrealestateproject.PropertyActivites;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.androidrealestateproject.R;
import com.example.androidrealestateproject.entity.Property;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;


public class PropertyDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Property");


        Intent intent = getIntent();
        if (intent != null) {
            String propertyJson = intent.getStringExtra("property");
            Property property = new Gson().fromJson(propertyJson, Property.class);
            displayPropertyDetails(property);
        }
    }

    private void displayPropertyDetails(Property property) {

        LinearLayout linearImages = findViewById(R.id.linearImages);
        TextView textViewPropertyName = findViewById(R.id.textViewPropertyName);
        TextView textViewPrice = findViewById(R.id.textViewPrice);
        TextView textViewAddress = findViewById(R.id.textViewAddress);
        TextView textViewNumberOfRooms = findViewById(R.id.textViewNumberOfRooms);
        TextView textViewPropertyType = findViewById(R.id.textViewPropertyType);


        if (property.getImageUrls() != null && property.getImageUrls().size() > 0) {
            for (String imageUrl : property.getImageUrls()) {
                ImageView imageView = new ImageView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        getResources().getDimensionPixelSize(R.dimen.property_image_width),
                        getResources().getDimensionPixelSize(R.dimen.property_image_height)
                );
                layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.property_image_margin), 0);
                imageView.setLayoutParams(layoutParams);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Picasso.get().load(imageUrl).into(imageView);
                linearImages.addView(imageView);
            }
        }


        textViewPropertyName.setText(property.getPropertyName());
        textViewPrice.setText("Price: $" + property.getPrice());
        textViewAddress.setText("Address: " + property.getAddress());
        textViewNumberOfRooms.setText("Rooms: " + property.getNumberOfRooms());
        textViewPropertyType.setText("Type: " + property.getPropertyType());



    }
}
