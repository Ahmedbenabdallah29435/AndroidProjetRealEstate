package com.example.androidrealestateproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
import java.time.format.DateTimeParseException;


public class test extends AppCompatActivity
{
   EditText t1,t4,t5;
   CheckBox t6 , t88;
   TextView lbl;

   Button b1,b2,b17;
    TechMasterDataBase app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        app = TechMasterDataBase.getRightCleanerDataBase(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);

        t1=findViewById(R.id.t1);

        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
t88=findViewById(R.id.t88);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        lbl=findViewById(R.id.lbl);
        b17=findViewById(R.id.b17);
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 // Récupérer les valeurs des champs
                 String title = t1.getText().toString().trim();
                 String dateString = t5.getText().toString().trim();
                 String description = t4.getText().toString().trim();

                 // Vérifier si les champs obligatoires sont vides
                 if (TextUtils.isEmpty(title) || TextUtils.isEmpty(dateString) || TextUtils.isEmpty(description)) {
                     // Afficher un message d'erreur ou effectuer une action appropriée
                     lbl.setText("Veuillez remplir tous les champs obligatoires.");
                     return;
                 }

                 // Continuer avec le reste du code si les champs obligatoires sont remplis

                 // Vérifier si la date est au bon format
                 try {
                     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                     LocalDate localDate = LocalDate.parse(dateString, formatter);
                 } catch (DateTimeParseException e) {
                     lbl.setText("Format de date incorrect. Utilisez le format yyyy-MM-dd.");
                     return;
                 }

                 // Vérifier si le titre existe déjà dans la base de données
                 TechMasterDataBase db = Room.databaseBuilder(getApplicationContext(),
                         TechMasterDataBase.class, "TechMaster").allowMainThreadQueries().build();
                 PostDao postDao = db.postDAO();
                 Boolean check = postDao.is_exist2(title);
                 if (!check) {
                     // Insérer le nouveau poste dans la base de données
                     CheckBox selectedCheckBox = t6.isChecked() ? t6 : t88;
                     String categoryString = selectedCheckBox.getText().toString();
                     Category category = Category.valueOf(categoryString);
                     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                     LocalDate localDate = LocalDate.parse(dateString, formatter);
                     postDao.insertrecord(new Post(title, localDate, category, description));
                     t1.setText("");
                     lbl.setText("Inséré avec succès");
                 } else {
                     t1.setText("");
                     lbl.setText("L'enregistrement existe déjà");
                 }



             }

         });

         b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(), fetchdata.class));
             }
         });

            b17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), ServiceChoice.class));
                }
            });


    }


}