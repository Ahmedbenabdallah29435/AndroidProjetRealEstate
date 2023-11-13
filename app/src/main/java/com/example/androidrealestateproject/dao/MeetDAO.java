package com.example.androidrealestateproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidrealestateproject.entity.Meet;

import java.util.List;

@Dao
public interface MeetDAO {
    @Query("SELECT * FROM meet")
    List<Meet> getAll();
    @Query("SELECT r.* FROM meet as  r WHERE r.emailServiceUser=:emailServiceUser")
    List<Meet> getMeetByEmailServiceUser(String emailServiceUser);
    @Query("SELECT r.* FROM meet as  r WHERE r.emailSimpleUser=:emailSimpleUser")
    List<Meet> getMeetByEmailSimpleUser(String emailSimpleUser);
    @Insert
    void addMeet(Meet meet);
    @Update
    void updateMeet(Meet meet);
    @Delete
    void deleteMeet(Meet meet);
}
