package com.example.androidrealestateproject.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import androidx.room.TypeConverters;

import com.example.androidrealestateproject.converters.ImageListConverter;
import com.example.androidrealestateproject.dao.MeetDAO;
import com.example.androidrealestateproject.dao.PropertyDao;

import com.example.androidrealestateproject.dao.ReviewDAO;
import com.example.androidrealestateproject.dao.UserDAO;
import com.example.androidrealestateproject.dao.UserServiceProviderDAO;
import com.example.androidrealestateproject.entity.Meet;

import com.example.androidrealestateproject.entity.Property;

import com.example.androidrealestateproject.entity.Review;
import com.example.androidrealestateproject.entity.User;
import com.example.androidrealestateproject.entity.UserServiceProvider;




@TypeConverters({ImageListConverter.class})
@Database(entities = {User.class, UserServiceProvider.class, Review.class, Meet.class, Property.class},version = 3, exportSchema = false)


public abstract class TechMasterDataBase extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract MeetDAO meetDAO();
    public abstract ReviewDAO reviewDAO();
    public abstract UserServiceProviderDAO userServiceProviderDAO();

    public abstract PropertyDao propertyDao();

    private static final String dbName="RightCleaner";
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