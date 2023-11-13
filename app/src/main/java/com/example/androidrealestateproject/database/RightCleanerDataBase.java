package com.example.androidrealestateproject.database;

import android.content.Context;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;

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


@Database(entities = {User.class, UserServiceProvider.class, Review.class, Meet.class, Property.class},version = 3, exportSchema = false)
@TypeConverters({ImageListConverter.class})
public abstract class RightCleanerDataBase extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract MeetDAO meetDAO();
    public abstract ReviewDAO reviewDAO();
    public abstract UserServiceProviderDAO userServiceProviderDAO();
    public abstract PropertyDao propertyDao();
    private static final String dbName="RightCleaner";
    private static RightCleanerDataBase rightCleanerDataBase;
    public static synchronized RightCleanerDataBase getRightCleanerDataBase(Context context){
        if(rightCleanerDataBase==null){

            rightCleanerDataBase= Room.databaseBuilder(context,RightCleanerDataBase.class,dbName)

                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return rightCleanerDataBase;
    }
}