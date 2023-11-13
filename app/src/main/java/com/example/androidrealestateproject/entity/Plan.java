package com.example.androidrealestateproject.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plans")
public class Plan {
    public Plan(Integer planid, String title, String picture, Double price, Integer livingroom, Integer kitchen, Integer wc, Integer room1, String description) {
        this.planid = planid;
        this.title = title;
        this.picture = picture;
        this.price = price;
        this.livingroom = livingroom;
        this.kitchen = kitchen;
        this.wc = wc;
        this.room1 = room1;
        this.description = description;
    }

    @PrimaryKey(autoGenerate = true)
    private Integer planid;

    @ColumnInfo(name = "title")
    private String title;

   @ColumnInfo(name = "picture")
    private String picture;

    @ColumnInfo(name = "price")
    private Double price;


    @ColumnInfo(name = "livingroom")
    private Integer livingroom;

    @ColumnInfo(name = "kitchen")
    private Integer kitchen;

    @ColumnInfo(name = "wc")
    private Integer wc;

    @ColumnInfo(name = "room1")
    private Integer room1;


    @ColumnInfo(name = "description")
    private String description;

    public Plan(String johnWick, String s, int a) {
    }


    public Integer getPlanid() {
        return planid;
    }


    public void setPlanid(Integer planid) {
        this.planid = planid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    public Integer getLivingroom() {
        return livingroom;
    }

    public void setLivingroom(Integer livingroom) {
        this.livingroom = livingroom;
    }

    public Integer getKitchen() {
        return kitchen;
    }

    public void setKitchen(Integer kitchen) {
        this.kitchen = kitchen;
    }

    public Integer getWc() {
        return wc;
    }

    public void setWc(Integer wc) {
        this.wc = wc;
    }

    public Integer getRoom1() {
        return room1;
    }

    public void setRoom1(Integer room1) {
        this.room1 = room1;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Plan(String title, Double price, Integer livingroom, Integer kitchen, Integer wc, Integer room1, Integer room2, String description) {
    }

    public Plan() {
    }

    public Plan(String title, String picture, Double price, Integer livingroom, Integer kitchen, Integer wc, Integer room1, String description) {
        this.title = title;
        this.picture = picture;
        this.price = price;
        this.livingroom = livingroom;
        this.kitchen = kitchen;
        this.wc = wc;
        this.room1 = room1;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "title='" + title + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", livingroom=" + livingroom +
                ", kitchen=" + kitchen +
                ", wc=" + wc +
                ", room1=" + room1 +
                ", description='" + description + '\'' +
                '}';
    }
}
