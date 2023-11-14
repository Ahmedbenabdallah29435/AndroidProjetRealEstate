package com.example.androidrealestateproject.PropertyActivites;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidrealestateproject.R;
import com.example.androidrealestateproject.adapters.ImageAdapter;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Property;
import com.example.androidrealestateproject.helper.SessionManagement;


import java.util.ArrayList;
import java.util.HashMap;

import gun0912.tedimagepicker.builder.TedImagePicker;

public class AddPropertyActivity extends AppCompatActivity {
    private TechMasterDataBase appDatabase;
    private EditText editTextPropertyName;
    private EditText editTextPrice;
    private EditText editTextAddress;
    private EditText editTextNumberOfRooms;
    private Spinner spinnerPropertyType;
    private RecyclerView recyclerViewSelectedImages;
    private Button buttonSave;
    private Button buttonCancel;
    SessionManagement session;

    private Button buttonPickImage;
    private ArrayList<String> selectedImagePaths = new ArrayList<>();

    private static final int REQUEST_CODE_PICKER = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);
        appDatabase = TechMasterDataBase.getRightCleanerDataBase(this);

        session=new SessionManagement(AddPropertyActivity.this);

        editTextPropertyName = findViewById(R.id.editTextPropertyName);
        editTextPrice = findViewById(R.id.editTextPrice);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextNumberOfRooms = findViewById(R.id.editTextNumberOfRooms);
        spinnerPropertyType = findViewById(R.id.spinnerPropertyType);
        buttonPickImage = findViewById(R.id.buttonPickImage);
        recyclerViewSelectedImages = findViewById(R.id.recyclerViewSelectedImages);
        buttonSave = findViewById(R.id.buttonSave);
        buttonCancel = findViewById(R.id.buttonCancel);

        String[] propertyTypes = {"Select Property Type", "House", "Apartment", "Villa", "Room"};
        ArrayAdapter<String> propertyTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, propertyTypes);
        propertyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPropertyType.setAdapter(propertyTypeAdapter);


        buttonPickImage = findViewById(R.id.buttonPickImage);
        buttonPickImage.setOnClickListener(view -> pickImages());

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProperty();
                finish();
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void pickImages() {
        TedImagePicker.with(this)
                .startMultiImage(uriList -> {
                    if (uriList != null && !uriList.isEmpty()) {
                        // Convert Uri list to String list
                        selectedImagePaths.clear();
                        for (Uri uri : uriList) {
                            selectedImagePaths.add(uri.toString());
                        }

                        // Update the UI to show the selected images
                        updateSelectedImagesUI();
                    }
                });
    }

    private void updateSelectedImagesUI() {
        RecyclerView recyclerViewSelectedImages = findViewById(R.id.recyclerViewSelectedImages);
        recyclerViewSelectedImages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ImageAdapter imageAdapter = new ImageAdapter(selectedImagePaths);
        recyclerViewSelectedImages.setAdapter(imageAdapter);

        recyclerViewSelectedImages.setVisibility(View.VISIBLE);
    }

    private void saveProperty(){
        String propertyName = editTextPropertyName.getText().toString();
        String price = editTextPrice.getText().toString();
        String address = editTextAddress.getText().toString();
        String numberOfRooms = editTextNumberOfRooms.getText().toString();
        String selectedPropertyType = (String) spinnerPropertyType.getSelectedItem();

        HashMap<String, Object> userDetails = session.getUserDetails();
        int ownerId = (int) userDetails.get(SessionManagement.KEY_ID);

        Property property = new Property();
        property.setPropertyName(propertyName);
        property.setPrice(Integer.parseInt(price));
        property.setAddress(address);
        property.setNumberOfRooms(Integer.parseInt(numberOfRooms));
        property.setPropertyType(selectedPropertyType);
        property.setImageUrls(selectedImagePaths);
        property.setOwnerId(ownerId);



        appDatabase.propertyDao().insert(property);
    }


}

