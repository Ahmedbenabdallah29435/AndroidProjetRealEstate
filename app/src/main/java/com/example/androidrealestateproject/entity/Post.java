package com.example.androidrealestateproject.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "post")
public class Post {
    @PrimaryKey(autoGenerate = true)
    private Integer postid;

    @ColumnInfo(name = "title")
    private String title;

   @ColumnInfo(name = "picture")
    private String picture;



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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Post(Integer postid, String title, String picture, String postContent) {
        this.postid = postid;
        this.title = title;
        this.picture = picture;
        this.postContent = postContent;
    }
}
