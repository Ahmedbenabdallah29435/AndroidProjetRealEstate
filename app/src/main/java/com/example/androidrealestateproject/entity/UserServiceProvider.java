package com.example.androidrealestateproject.entity;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
@Entity
public class UserServiceProvider extends User{
    @ColumnInfo(name = "service")
    String service;
    @ColumnInfo(name = "price")
    String price;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
