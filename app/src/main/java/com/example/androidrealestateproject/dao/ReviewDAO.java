package com.example.androidrealestateproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidrealestateproject.entity.Review;

import java.util.List;
@Dao
public interface ReviewDAO {
    @Query("SELECT * FROM review")
    List<Review> getAll();
    @Query("SELECT r.* FROM review as  r WHERE r.emailServiceUser=:emailServiceUser")
    List<Review> getReviewByEmailServiceUser(String emailServiceUser);
    @Query("SELECT r.* FROM review as  r WHERE r.emailSimpleUser=:emailSimpleUser")
    List<Review> getReviewByEmailSimpleUser(String emailSimpleUser);
    @Insert
    void addReview(Review review);
    @Update
    void updateReview(Review review);
    @Delete
    void deleteReview(Review review);
}
