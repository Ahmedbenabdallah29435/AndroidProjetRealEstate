package com.example.androidrealestateproject.PropertyActivites;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.androidrealestateproject.R;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Property;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class UserPropertyDetailsActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_EDIT_PROPERTY = 101;
    private TechMasterDataBase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_property_details);
        appDatabase = TechMasterDataBase.getRightCleanerDataBase(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Property");


        Intent intent = getIntent();
        if (intent != null) {
            String propertyJson = intent.getStringExtra("property");
            Property property = new Gson().fromJson(propertyJson, Property.class);
            displayPropertyDetails(property);


            Button deleteButton = findViewById(R.id.buttonDelete);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDeleteConfirmationDialog();
                }
            });
            Button editButton = findViewById(R.id.buttonEdit);
            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onEditButtonClick(property);
                }
            });
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
    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Delete")
                .setMessage("Are you sure you want to delete this property?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteProperty();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }
    private void deleteProperty() {
        Intent intent = getIntent();
        if (intent != null) {
            String propertyJson = intent.getStringExtra("property");
            Property property = new Gson().fromJson(propertyJson, Property.class);
            appDatabase.propertyDao().delete(property);
            Toast.makeText(this, "Property deleted successfully", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    private void onEditButtonClick(Property property) {
        Intent intent = new Intent(this, EditPropertyActivity.class);
        intent.putExtra("property", new Gson().toJson(property));
        startActivityForResult(intent, REQUEST_CODE_EDIT_PROPERTY);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_EDIT_PROPERTY && resultCode == RESULT_OK) {
            recreate();
        }
    }
}


