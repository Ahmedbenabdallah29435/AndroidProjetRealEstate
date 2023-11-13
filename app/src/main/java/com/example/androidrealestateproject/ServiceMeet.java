package com.example.androidrealestateproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidrealestateproject.dao.MeetDAO;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Meet;

public class ServiceMeet extends AppCompatActivity {

    EditText meetText,dateMeet;
    Button btnAddMeet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet);
        meetText=findViewById(R.id.meetText);
        dateMeet = findViewById(R.id.DateMeet);
        btnAddMeet=findViewById(R.id.btnAddMeet);
        btnAddMeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TechMasterDataBase techMasterDataBase = TechMasterDataBase.getRightCleanerDataBase(getApplicationContext());
                final MeetDAO meetDAO= techMasterDataBase.meetDAO();
                Meet meet = new Meet();

                meet.setDescription(meetText.getText().toString());
                meet.setDate(dateMeet.getText().toString());
                if(validateInput(meet)){
                    meetDAO.addMeet(meet);
                    Toast.makeText(getApplicationContext(),"Add Review",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Make sure to fill all the fields",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    private Boolean validateInput(Meet meet){
        if(meet.getDescription().isEmpty()|| meet.getDate().isEmpty()){
            return  false;
        }
        return true;
    }

}
