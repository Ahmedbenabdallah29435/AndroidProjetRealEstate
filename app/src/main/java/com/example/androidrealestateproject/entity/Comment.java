package com.example.androidrealestateproject.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.time.LocalDate;
@Entity(tableName = "post")
public class Comment {
    @PrimaryKey(autoGenerate = true)
    private Integer commentId;

    @ColumnInfo(name = "commentDate")
    private LocalDate commentDate;


    @ColumnInfo(name = "user_id")
    private User user;

    @ColumnInfo(name = "postId")
    private Post post;



}
