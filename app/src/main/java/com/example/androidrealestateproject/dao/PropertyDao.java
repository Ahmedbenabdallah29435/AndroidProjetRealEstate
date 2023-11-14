package com.example.androidrealestateproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidrealestateproject.entity.Property;

import java.util.List;

@Dao
public interface PropertyDao {
    @Insert
    void insert(Property property);

    @Query("SELECT * FROM Property")
    List<Property> getAllProperties();
    @Query("SELECT * FROM Property WHERE ownerId = :userId")
    List<Property> getPropertiesByUserId(int userId);
    @Delete
    void delete(Property property);
    @Update
    void update(Property property);
}
