package com.example.androidrealestateproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SimpleUserHomePage2 extends AppCompatActivity {
    Button btn;

    /**
    TechMasterDataBase techMasterDataBase;
    UserDAO userDAO;
    SessionManagement sessionManagement;
    RecyclerView listproviders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManagement=new SessionManagement(this);
        techMasterDataBase= TechMasterDataBase.getRightCleanerDataBase(getApplicationContext());
        userDAO=techMasterDataBase.userDAO();
        setContentView(R.layout.activity_simple_user_home_page2);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listproviders=findViewById(R.id.listproviders);
        ServiceProviderAdapter adapter = new ServiceProviderAdapter(this);
        listproviders.setAdapter(adapter);
        listproviders.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
/*
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SessionManagement sessionManagement = new SessionManagement(getApplicationContext());
        switch (item.getItemId()) {
            case R.id.homeP: {
                startActivity(new Intent(this,ServiceChoice.class));
                break;
            }
            case R.id.profileP:{
                startActivity(new Intent(this,ProfilePage.class));
                break;
            }
            case  R.id.logOut:{
                sessionManagement.logoutUser();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
*//*
    @Override
    protected void onStart() {
        super.onStart();
        listproviders=findViewById(R.id.listproviders);
        ServiceProviderAdapter adapter = new ServiceProviderAdapter(this);
        listproviders.setAdapter(adapter);
        listproviders.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        if (!sessionManagement.isLoggedIn()) {
            sendToLoginPage();
        }
    }
    public void sendToLoginPage(){
        startActivity(new Intent(this,MainActivity.class));

    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_user_home_page2);  // You need to have the "activity_main.xml" layout file
        btn=findViewById(R.id.house1);
        btn.setOnClickListener(e -> {
            Intent intent = new Intent (this, AddPost.class);
            startActivity(intent);
        });
    }

    
}



