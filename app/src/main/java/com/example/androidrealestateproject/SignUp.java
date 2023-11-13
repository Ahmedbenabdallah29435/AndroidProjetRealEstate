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

public class SignUp extends AppCompatActivity {
        EditText username,email,phoneNumber,pass;
        TextView loginView;
        Button addRev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username=findViewById(R.id.userName);
        email=findViewById(R.id.email);
        phoneNumber=findViewById(R.id.phoneN);
        pass=findViewById(R.id.pass);
        loginView=findViewById(R.id.logInSignU);
        loginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
      Button  signup=findViewById(R.id.btnSignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User nUser=new User();
                TechMasterDataBase techMasterDataBase = TechMasterDataBase.getRightCleanerDataBase(getApplicationContext());

                final UserDAO userDAO= techMasterDataBase.userDAO();
                nUser.setUsername(username.getText().toString());
                    nUser.setEmail(email.getText().toString());
                    nUser.setPassword(pass.getText().toString());
                    nUser.setPhoneNumber(phoneNumber.getText().toString());
                    nUser.setRole(Role.SIMPLE_USER.toString());
                    if(validateInput(nUser)){

                       new Thread(new Runnable() {
                           @Override
                           public void run() {
                               userDAO.register(nUser);
                               runOnUiThread(new Runnable() {
                                   @Override
                                   public void run() {
                                       Toast.makeText(getApplicationContext(),"You haved registed",Toast.LENGTH_SHORT).show();
                                   }
                               });

                           }
                       }).start();
                    }else {
                        Toast.makeText(getApplicationContext(),"Make sure to fill all the fields",Toast.LENGTH_SHORT).show();
                    }
                Log.i("data",userDAO.toString());

            }
        });

    }


    private Boolean validateInput(User user){
        if(user.getEmail().isEmpty()|| user.getPassword().isEmpty()||user.getPhoneNumber().isEmpty()){
            return  false;
        }
        return true;
    }

}