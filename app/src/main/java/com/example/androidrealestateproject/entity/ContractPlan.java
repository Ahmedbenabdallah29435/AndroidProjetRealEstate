package com.example.androidrealestateproject.entity;

import androidx.room.ColumnInfo;

import java.time.LocalDate;

public class ContractPlan {
    private Integer contractId;

    @ColumnInfo(name = "contractDate")

    private LocalDate contractDate;

    @ColumnInfo(name = "price")

    private Double price;
    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "user_id")
    private User user;

    @ColumnInfo(name = "planId")
    private Plan plan;



    public int getIdContrat() {
        return this.contractId;
    }

    public String getStatus() {
        return this.status;
    }
}
