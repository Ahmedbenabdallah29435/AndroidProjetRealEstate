package com.example.androidrealestateproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidrealestateproject.entity.UserServiceProvider;

import java.util.List;

@Dao
public interface UserServiceProviderDAO {
    @Query("SELECT * FROM UserServiceProvider")
    List<UserServiceProvider> getAll();
    @Query("SELECT * FROM USERSERVICEPROVIDER where service=:service")
    List<UserServiceProvider> getByService(String service);
    @Insert
    void register(UserServiceProvider userServiceProvider);
    @Update
    void updateUserServiceProvider(UserServiceProvider userServiceProvider);
    @Delete
    void deleteUserServiceProvider(UserServiceProvider userServiceProvider);

}
