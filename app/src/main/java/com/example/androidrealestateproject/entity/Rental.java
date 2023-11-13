package com.example.androidrealestateproject.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity(tableName = "rentals")

public class Rental {
    @PrimaryKey(autoGenerate = true)

    private Integer offreid;
    @ColumnInfo(name = "title")

    private String title;
    @ColumnInfo(name = "description")

    private String description;
    @ColumnInfo(name = "picture")

    private String picture;
    @ColumnInfo(name = "monthlyrent")

    private Double monthlyrent;

    public Integer getOffreid() {
        return offreid;
    }

    public void setOffreid(Integer offreid) {
        this.offreid = offreid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getMonthlyrent() {
        return monthlyrent;
    }

    public void setMonthlyrent(Double monthlyrent) {
        this.monthlyrent = monthlyrent;
    }
}
