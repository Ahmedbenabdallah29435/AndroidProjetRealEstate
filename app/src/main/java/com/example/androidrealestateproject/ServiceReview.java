package com.example.androidrealestateproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidrealestateproject.dao.ReviewDAO;
import com.example.androidrealestateproject.database.TechMasterDataBase;
import com.example.androidrealestateproject.entity.Review;
import com.example.androidrealestateproject.helper.ReviewStatus;

public class ServiceReview extends AppCompatActivity {

    EditText reviewText;
    Spinner spinnerReview;
    Button addReview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        reviewText=findViewById(R.id.ReviewText);
        String[] arraySpinnerReview = new String[] {
                ReviewStatus.GOOD.toString(), ReviewStatus.AVERAGE.toString(), ReviewStatus.BAD.toString()
        };
        spinnerReview=findViewById(R.id.spinnerReview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerReview);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerReview.setAdapter(adapter);
        addReview=findViewById(R.id.btnAddReview);
        addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TechMasterDataBase techMasterDataBase = TechMasterDataBase.getRightCleanerDataBase(getApplicationContext());
                final ReviewDAO reviewDAO= techMasterDataBase.reviewDAO();
                Review review = new Review();

                review.setReview(reviewText.getText().toString());
                review.setStatus(spinnerReview.getSelectedItem().toString());
                if(validateInput(review)){
                    reviewDAO.addReview(review);
                    Toast.makeText(getApplicationContext(),"Add Review",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Make sure to fill all the fields",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    private Boolean validateInput(Review review){
        if(review.getReview().isEmpty()|| review.getStatus().isEmpty()){
            return  false;
        }
        return true;
    }

}