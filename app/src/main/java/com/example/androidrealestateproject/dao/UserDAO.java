package com.example.androidrealestateproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidrealestateproject.entity.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM users")
    List<User> getAll();
    @Query("SELECT u.* FROM users as  u WHERE id=:userId")
    User getUserId(int userId);
    @Query("SELECT u.* FROM users as  u WHERE email=:email")
    User getUserByEmail(String email);
    @Query("SELECT u.* FROM users u WHERE u.email=:email AND u.password=:password")
    User Login(String email,String password);
    @Insert
    void register(User user);
    @Update
    void updateUser(User user);
    @Delete
    void deleteUser(User user);


}
