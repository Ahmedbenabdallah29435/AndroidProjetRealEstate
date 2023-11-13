package com.example.androidrealestateproject.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "review")
public class Review {
    @PrimaryKey(autoGenerate = true)
    Integer id;
    @ColumnInfo(name = "review")
    String review;
    @ColumnInfo(name = "emailSimpleUser")
    String emailSimpleUser;
    @ColumnInfo(name = "emailServiceUser")
    String emailServiceUser;
    @ColumnInfo(name = "status")
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
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
}
