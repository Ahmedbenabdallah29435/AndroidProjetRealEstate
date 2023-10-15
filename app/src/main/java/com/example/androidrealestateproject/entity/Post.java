package com.example.androidrealestateproject.entity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;

public class Post
{
    @PrimaryKey(autoGenerate = true)
    Integer postId;
    @ColumnInfo(name = "title")
    String title;
    @ColumnInfo(name = "image")
    String image;
    @ColumnInfo(name = "postContent")
    String postContent;
    @ColumnInfo(name = "category")
    String category;
    @ColumnInfo(name = "postdate")
    String postdate;

    @ColumnInfo(name = "user_id")
    private User user;
    @Relation(parentColumn = "id", entityColumn = "commentId")
    public List<Comment> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}
