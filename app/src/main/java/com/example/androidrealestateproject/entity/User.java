package com.example.androidrealestateproject.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;

@Entity(tableName = "users",indices = {@Index(value = {"email"},unique = true)})
public class User {
    @PrimaryKey(autoGenerate = true)
    Integer id;
    @ColumnInfo(name = "password")
    String password;
    @ColumnInfo(name = "username")
    String username;

    @ColumnInfo(name = "email")
    String email;
    @ColumnInfo(name = "phoneNumber")
    String phoneNumber;
    @ColumnInfo(name = "role")
    String role;
    /**
    @Relation(parentColumn = "id", entityColumn = "user_id")
    public List<Post> plans;

    @Relation(parentColumn = "id", entityColumn = "contratplanid")
    public List<Comment> contractPlans;
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
