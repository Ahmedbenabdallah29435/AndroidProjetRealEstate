package com.example.androidrealestateproject;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



import com.example.androidrealestateproject.dao.UserDAO;
import com.example.androidrealestateproject.dao.UserServiceProviderDAO;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.UserServiceProvider;
import com.example.androidrealestateproject.helper.Role;
import com.example.androidrealestateproject.helper.ServiceCategory;

public class ServiceProviderSignUpPage extends AppCompatActivity {

    EditText username,email,phoneNumber,pass;
    Spinner service,price;
    Button signup;
    TextView loginView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_sign_up_page);
        username=findViewById(R.id.usernameService);
        email=findViewById(R.id.emailService);
        phoneNumber=findViewById(R.id.phoneService);
        pass=findViewById(R.id.passwordService);
        loginView=findViewById(R.id.logInSignU);
        loginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        String[] arraySpinner = new String[] {
                ServiceCategory.ELECTRICIAN.toString(), ServiceCategory.HOUSE_CLEANING.toString(), ServiceCategory.GARDENER.toString()
        };
        String[] arraySpinnerPrice = new String[] {
                "10 - 20", "20 - 30", "30 - 40","Other"
        };
        service=findViewById(R.id.service);
        price=findViewById(R.id.price);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        service.setAdapter(adapter);
        ArrayAdapter<String> adapterPrice = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerPrice);
        adapterPrice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        price.setAdapter(adapterPrice);
        signup=findViewById(R.id.btnSignupService);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TechMasterDataBase techMasterDataBase = TechMasterDataBase.getRightCleanerDataBase(getApplicationContext());
                final UserDAO  userDAO= techMasterDataBase.userDAO();
                final UserServiceProviderDAO  userServiceProviderDAO= techMasterDataBase.userServiceProviderDAO();
                UserServiceProvider user = new UserServiceProvider();

                user.setEmail(email.getText().toString());
                user.setPassword(pass.getText().toString());
                user.setPhoneNumber(phoneNumber.getText().toString());
                user.setService(service.getSelectedItem().toString());
                user.setPrice(price.getSelectedItem().toString());
                user.setRole(Role.Service_Provider.toString());
                    if(validateInput(user)){
                        userDAO.register(user);
                        userServiceProviderDAO.register(user);
                        Toast.makeText(getApplicationContext(),"You haved registed",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Make sure to fill all the fields",Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }


    private Boolean validateInput(UserServiceProvider userServiceProvider){
        if(userServiceProvider.getEmail().isEmpty()|| userServiceProvider.getPassword().isEmpty()||userServiceProvider.getPhoneNumber().isEmpty()){
            return  false;
        }
        return true;
    }

}