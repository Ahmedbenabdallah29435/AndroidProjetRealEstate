package com.example.androidrealestateproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidrealestateproject.entity.Plan;

import java.util.List;

@Dao
public interface PlanDAO {
    @Query("SELECT * FROM plans")
    List<Plan> getAll();
    @Query("SELECT p.* FROM plans as  p WHERE planid=:planid")
    Plan getPlanId(int planid);
    @Insert
    void addPlan(Plan plan);
    @Update
    void updatePlan(Plan plan);
    @Delete
    void deleteUser(Plan plan);
    @Query("UPDATE PLANS SET title = :title, price=:price,livingroom = :livingroom, kitchen = :kitchen, wc = :wc, room1 = :room, picture = :image,description= :description WHERE planid = :id")
    void updateById(int id, String title, Double price, int livingroom,int kitchen,int wc,int room, String image,String description);


}
