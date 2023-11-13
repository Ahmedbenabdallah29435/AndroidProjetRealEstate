package com.example.androidrealestateproject.PropertyActivites;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidrealestateproject.R;
import com.example.androidrealestateproject.adapters.ImageAdapter;
import com.example.androidrealestateproject.database.RightCleanerDataBase;
import com.example.androidrealestateproject.entity.Property;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import gun0912.tedimagepicker.builder.TedImagePicker;

public class EditPropertyActivity extends AppCompatActivity {
    private RightCleanerDataBase appDatabase;
    private EditText editTextPropertyName;
    private EditText editTextPrice;
    private EditText editTextAddress;
    private EditText editTextNumberOfRooms;
    private Spinner spinnerPropertyType;
    private RecyclerView recyclerViewSelectedImages;
    private Button buttonSaveEdit;
    private Button buttonCancel;
    private Button buttonPickImageEdit;
    private ArrayList<String> selectedImagePaths = new ArrayList<>();
    private Property originalProperty;
    private List<String> newImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_property);
        appDatabase = RightCleanerDataBase.getRightCleanerDataBase(this);


        editTextPropertyName = findViewById(R.id.editTextEditedPropertyName);
        editTextPrice = findViewById(R.id.editTextEditedPrice);
        editTextAddress = findViewById(R.id.editTextEditedAddress);
        editTextNumberOfRooms = findViewById(R.id.editTextEditedNumberOfRooms);
        spinnerPropertyType = findViewById(R.id.spinnerEditedPropertyType);
        buttonSaveEdit = findViewById(R.id.buttonSaveEditedProperty);
        buttonCancel = findViewById(R.id.buttonDeleteEditedProperty);
        buttonPickImageEdit = findViewById(R.id.buttonPickImageEdit);
        buttonPickImageEdit.setOnClickListener(view -> pickImages());
        recyclerViewSelectedImages = findViewById(R.id.recyclerViewEditSelectedImages);


        String propertyJson = getIntent().getStringExtra("property");
        originalProperty = new Gson().fromJson(propertyJson, Property.class);
        populateUI(originalProperty);
        setupSpinner();
        buttonSaveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveEditedProperty();
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void setupSpinner() {
        String[] propertyTypes = {"Select Property Type", "House", "Apartment", "Villa", "Room"};
        ArrayAdapter<String> propertyTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, propertyTypes);
        propertyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPropertyType.setAdapter(propertyTypeAdapter);
    }
    private void populateUI(Property property) {
        editTextPropertyName.setText(property.getPropertyName());
        editTextPrice.setText(String.valueOf(property.getPrice()));
        editTextAddress.setText(property.getAddress());
        editTextNumberOfRooms.setText(String.valueOf(property.getNumberOfRooms()));
        setSpinnerSelection(property.getPropertyType());

        List<String> imageUrls = property.getImageUrls();


        if (imageUrls != null && !imageUrls.isEmpty()) {
            recyclerViewSelectedImages.setVisibility(View.VISIBLE);
            updateSelectedImagesUI(imageUrls);
        } else {
            recyclerViewSelectedImages.setVisibility(View.GONE);
        }
    }
    private void setSpinnerSelection(String propertyType) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) spinnerPropertyType.getAdapter();
        if (adapter != null) {
            for (int i = 0; i < adapter.getCount(); i++) {
                if (adapter.getItem(i).equals(propertyType)) {
                    spinnerPropertyType.setSelection(i);
                    return; // Exit the loop once a match is found
                }
            }
        }
    }
    private void saveEditedProperty() {
        String editedPropertyName = editTextPropertyName.getText().toString();
        int editedPrice = Integer.parseInt(editTextPrice.getText().toString());
        String editedAddress = editTextAddress.getText().toString();
        int editedNumberOfRooms = Integer.parseInt(editTextNumberOfRooms.getText().toString());
        String editedPropertyType = spinnerPropertyType.getSelectedItem().toString();


        originalProperty.setPropertyName(editedPropertyName);
        originalProperty.setPrice(editedPrice);
        originalProperty.setAddress(editedAddress);
        originalProperty.setNumberOfRooms(editedNumberOfRooms);
        originalProperty.setPropertyType(editedPropertyType);
        originalProperty.setImageUrls(newImageUrls);


        appDatabase.propertyDao().update(originalProperty);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("edited_property", new Gson().toJson(originalProperty));
        setResult(RESULT_OK, resultIntent);


        finish();
    }
    private void pickImages() {
        TedImagePicker.with(this)
                .startMultiImage(uriList -> {
                    if (uriList != null && !uriList.isEmpty()) {
                        // Convert Uri list to String list
                        selectedImagePaths.clear();
                        newImageUrls.clear(); // Clear existing URLs
                        for (Uri uri : uriList) {
                            String imageUrl = uri.toString();
                            selectedImagePaths.add(imageUrl);
                            newImageUrls.add(imageUrl); // Add the new URL to the list
                        }
                        updateSelectedImagesUI(selectedImagePaths);
                    }
                });
    }

    private void updateSelectedImagesUI(List<String> imageUrls) {
        ImageAdapter imageAdapter = new ImageAdapter(imageUrls);
        recyclerViewSelectedImages.setAdapter(imageAdapter);
        recyclerViewSelectedImages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}
