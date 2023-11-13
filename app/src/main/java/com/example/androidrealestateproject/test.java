package com.example.androidrealestateproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.androidrealestateproject.dao.PostDao;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Category;
import com.example.androidrealestateproject.entity.Post;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class test extends AppCompatActivity
{
   EditText t1,t2,t3,t4,t5,t6,t;
   TextView lbl;
   Button b1,b2;
    TechMasterDataBase app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        app = TechMasterDataBase.getRightCleanerDataBase(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t=findViewById(R.id.t);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        lbl=findViewById(R.id.lbl);

         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String dateString = t5.getText().toString();
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                 LocalDate localDate = LocalDate.parse(dateString, formatter);
                 // Assuming t6.getText().toString() contains a valid Category name
                 String categoryString = t6.getText().toString();
                 Category category = Category.valueOf(categoryString);
                 //..
                 TechMasterDataBase db = Room.databaseBuilder(getApplicationContext(),
                         TechMasterDataBase.class, "TechMaster").allowMainThreadQueries().build();
                 PostDao postDao = db.postDAO();
                 Boolean check=postDao.is_exist(Integer.parseInt(t1.getText().toString()));
                 if(check==false) {
                     postDao.insertrecord(new Post(t4.getText().toString(), localDate ,category,t1.getText().toString()));
                     t1.setText("");
                     t2.setText("");
                     t3.setText("");
                     lbl.setText("Inserted Successfully");
                 }
                 else
                 {
                     t1.setText("");
                     t2.setText("");
                     t3.setText("");
                     lbl.setText("Record is existing");
                 }
             }
         });

         b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(), fetchdata.class));
             }
         });

    }


}