package com.example.androidrealestateproject.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.time.LocalDate;
import java.util.Date;

@Entity(tableName = "post")
@TypeConverters({DateTypeConverter.class})
public class Post {
    @PrimaryKey(autoGenerate = true)
    private Integer postid;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "postDate")
    private LocalDate postDate;

    @ColumnInfo(name ="category")
    private Category category;
    @ColumnInfo(name = "postContent")
    private String postContent;

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
       this.postDate = postDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Post(Integer postid, String title, LocalDate postDate, Category category, String postContent) {
        this.postid = postid;
        this.title = title;
        this.postDate = postDate;
        this.category = category;
        this.postContent = postContent;
    }

    public Post() {
    }
}
