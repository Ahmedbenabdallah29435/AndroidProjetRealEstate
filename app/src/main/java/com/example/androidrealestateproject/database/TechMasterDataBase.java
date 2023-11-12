package com.example.androidrealestateproject.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androidrealestateproject.dao.MeetDAO;
import com.example.androidrealestateproject.dao.PostDAO;
import com.example.androidrealestateproject.dao.ReviewDAO;
import com.example.androidrealestateproject.dao.UserDAO;
import com.example.androidrealestateproject.dao.UserServiceProviderDAO;
import com.example.androidrealestateproject.entity.Meet;
import com.example.androidrealestateproject.entity.Review;
import com.example.androidrealestateproject.entity.User;
import com.example.androidrealestateproject.entity.UserServiceProvider;
import com.example.androidrealestateproject.entity.Post;

@Database(entities = {User.class, UserServiceProvider.class, Review.class, Meet.class ,Post.class},version = 3, exportSchema = false)

public abstract class TechMasterDataBase extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract MeetDAO meetDAO();

    public abstract PostDAO postDAO();
    public abstract ReviewDAO reviewDAO();
    public abstract UserServiceProviderDAO userServiceProviderDAO();
    private static final String dbName="TechMaster";
    private static TechMasterDataBase techMasterDataBase;
    public static synchronized TechMasterDataBase getRightCleanerDataBase(Context context){
        if(techMasterDataBase ==null){

            techMasterDataBase = Room.databaseBuilder(context, TechMasterDataBase.class,dbName)

                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return techMasterDataBase;
    }
}