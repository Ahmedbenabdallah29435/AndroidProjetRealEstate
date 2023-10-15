package com.example.androidrealestateproject.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meet")
public class Meet {
    @PrimaryKey(autoGenerate = true)
    Integer id;
    @ColumnInfo(name = "description")
    String description;
    @ColumnInfo(name = "emailSimpleUser")
    String emailSimpleUser;
    @ColumnInfo(name = "emailServiceUser")
    String emailServiceUser;
    @ColumnInfo(name = "date")
    String date;
    @ColumnInfo(name = "status")
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailSimpleUser() {
        return emailSimpleUser;
    }

    public void setEmailSimpleUser(String emailSimpleUser) {
        this.emailSimpleUser = emailSimpleUser;
    }

    public String getEmailServiceUser() {
        return emailServiceUser;
    }

    public void setEmailServiceUser(String emailServiceUser) {
        this.emailServiceUser = emailServiceUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
