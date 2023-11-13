package com.example.androidrealestateproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.androidrealestateproject.dao.UserDAO;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.User;
import com.example.androidrealestateproject.helper.Role;
import com.example.androidrealestateproject.helper.SessionManagement;

public class MainActivity extends AppCompatActivity {

    TextView creatAccoutUser,createServiceProvider;
    EditText username;
    EditText password;
    Button loginBtn;
    TechMasterDataBase techMasterDataBase;
    UserDAO  userDAO;
    SessionManagement sessionManagement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sessionManagement=new SessionManagement(MainActivity.this);
        techMasterDataBase = TechMasterDataBase.getRightCleanerDataBase(getApplicationContext());
        userDAO= techMasterDataBase.userDAO();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        username = findViewById(R.id.usernameLogin);
        password = findViewById(R.id.passwordLogin);

        loginBtn = findViewById(R.id.HouseCleaningBtn);
        creatAccoutUser=findViewById(R.id.signUpLink);
        createServiceProvider=findViewById(R.id.signUpProvider);
        creatAccoutUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });
        createServiceProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ServiceProviderSignUpPage.class);
                startActivity(intent);
            }
        });

        techMasterDataBase.isOpen();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(v);
            }
        });
    }

    public void login(View view){
        String name = username.getText().toString();
        String pwd = password.getText().toString();
        Log.i("name",name);
        Log.i("pass",pwd);
        User user = userDAO.Login(name,pwd);
        if(user!=null){
            Log.i("name",user.getEmail());
            Log.i("pass",user.getPassword());
            sessionManagement.createLoginSession(user.getEmail(),user.getPassword(),user.getId());
            moveToHomePage(user);
        }else {
            Toast.makeText(getApplicationContext(),"Check your inputs",Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();

        if(sessionManagement.isLoggedIn()){
            Log.i("id", sessionManagement.getUserDetails().get("id").getClass().toString());
            moveToHomePage(userDAO.getUserId(Integer.parseInt(sessionManagement.getUserDetails().get("id").toString())));
        }


    }
    public void moveToHomePage(User user) {
        if (user != null) {
            String role = user.getRole();

            if (Role.SIMPLE_USER.toString().equals(role)) {
                Intent intent = new Intent(MainActivity.this, ServiceChoice.class);
                startActivity(intent);
            } else if (user.getRole().equals(Role.Service_Provider.toString())) {
                Intent intent = new Intent(MainActivity.this, ServiceChoice.class);
                startActivity(intent);
            }
        } else {
            Intent intent = new Intent(MainActivity.this, SignUp.class);
            startActivity(intent);
        }
    }




}