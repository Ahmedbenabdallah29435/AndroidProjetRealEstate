package com.example.androidrealestateproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidrealestateproject.entity.Plan;
import com.example.androidrealestateproject.entity.Rental;

import java.util.List;

@Dao

public interface RentalDAO {
    @Query("SELECT * FROM rentals")
    List<Rental> getAll();
    @Query("SELECT p.* FROM rentals as  p WHERE offreid=:rentalid")
    Rental getRentalId(int rentalid);
    @Insert
    void addRental(Rental rental);
    @Update
    void updateRental(Rental rental);
    @Delete
    void deleteUser(Rental rental);
    @Query("UPDATE RENTALS SET title = :title, monthlyrent= :monthlyrent, picture = :image,description= :description WHERE offreid = :id")
    void updateById(int id, String title, Double monthlyrent, String image,String description);
    @Query("DELETE FROM RENTALS WHERE offreid = :id")
    void deleteById(int id);
}
