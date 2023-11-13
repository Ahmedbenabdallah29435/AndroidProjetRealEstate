package com.example.androidrealestateproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidrealestateproject.dao.UserDAO;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.User;
import com.example.androidrealestateproject.helper.SessionManagement;
import com.example.androidrealestateproject.listServiceProviders.ServiceReviewAdapter;
public class ProfilePage extends AppCompatActivity {
    TextView fname, email, birthdate, phone;
    TechMasterDataBase techMasterDataBase;
    RecyclerView listReview;
    UserDAO userDAO;
    SessionManagement sessionManagement;
    Button addrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Move the initialization of listReview here
        listReview = findViewById(R.id.listReview);

        techMasterDataBase = TechMasterDataBase.getRightCleanerDataBase(getApplicationContext());
        userDAO = techMasterDataBase.userDAO();
        sessionManagement = new SessionManagement(getApplicationContext());

        ServiceReviewAdapter adapter = new ServiceReviewAdapter(this);
        listReview.setAdapter(adapter);
        listReview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        User user = (User) getIntent().getSerializableExtra("user");
        fillProfile(user);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Move the initialization of listReview here
        listReview = findViewById(R.id.listReview);

        if (!sessionManagement.isLoggedIn()) {
            sendToLoginPage();
        }

        ServiceReviewAdapter adapter = new ServiceReviewAdapter(this);
        listReview.setAdapter(adapter);
        listReview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        fillProfile(userDAO.getUserId(Integer.parseInt(sessionManagement.getUserDetails().get("id").toString())));
    }

    public void sendToLoginPage() {
        startActivity(new Intent(this, MainActivity.class));
        finish(); // Finish the current activity to prevent returning to it using the back button
    }

    public void fillProfile(User user) {
        fname = findViewById(R.id.fname);
        addrev = findViewById(R.id.addRev);
        email = findViewById(R.id.emailT);
        birthdate = findViewById(R.id.birthDate);
        phone = findViewById(R.id.phone);

        if (user != null) {
            fname.setText(user.getUsername());
            email.setText(user.getEmail());
            // Note: You have "birthdate.setText("test");", consider setting the actual birthdate value here.
            phone.setText(user.getPhoneNumber());
        } else {
            fname.setText("NNan");
            email.setText("NNan");
            birthdate.setText("NNan");
            phone.setText("NNan");
        }

        if (sessionManagement.getProfile().containsKey("profile") && !sessionManagement.getProfile().get("profile").toString().isEmpty()) {
            if (user != null && user.getEmail().equals(sessionManagement.getProfile().get("profile").toString())) {
                addrev.setVisibility(View.GONE);
            }
        } else {
            addrev.setVisibility(View.GONE);
        }
    }
}
