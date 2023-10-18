package com.example.androidrealestateproject.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;
import java.util.Set;

@Entity()
public class Plan {
    @PrimaryKey(autoGenerate = true)
    private Integer planid;

    @ColumnInfo(name = "title")
    private String title;

   @ColumnInfo(name = "picture")
    private String picture;

    @ColumnInfo(name = "price")
    private Double price;

    @ColumnInfo(name = "realizationprice")
    private Double realizationprice;

    @ColumnInfo(name = "livingroom")
    private Integer livingroom;

    @ColumnInfo(name = "kitchen")
    private Integer kitchen;

    @ColumnInfo(name = "wc")
    private Integer wc;

    @ColumnInfo(name = "room1")
    private Integer room1;

    @ColumnInfo(name = "room2")
    private Integer room2;

    @ColumnInfo(name = "description")
    private String description;

 /**   @ColumnInfo(name = "user_id")
    private User user;
*/
 /**
    @Relation(parentColumn = "id", entityColumn = "contratplanid")
    public List<ContractPlan> contractPlans;
*/
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

    public Double getRealizationprice() {
        return realizationprice;
    }

    public void setRealizationprice(Double realizationprice) {
        this.realizationprice = realizationprice;
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

    public Integer getRoom2() {
        return room2;
    }

    public void setRoom2(Integer room2) {
        this.room2 = room2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
/**
    private Set<ContractPlan> planContractPlanContractPlans;

*/


    public Plan(String title, Double price, Double realizationprice, Integer livingroom, Integer kitchen, Integer wc, Integer room1, Integer room2, String description) {
    }


}
