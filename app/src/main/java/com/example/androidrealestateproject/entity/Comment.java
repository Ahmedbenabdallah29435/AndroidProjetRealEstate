package com.example.androidrealestateproject.entity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

public class Comment {

    @PrimaryKey(autoGenerate = true)
    private Integer commentId;
    @ColumnInfo(name = "commentdate")
    private LocalDateTime commentDate;
    @ColumnInfo(name = "commentContent")
    private String commentContent;

    @ColumnInfo(name = "user_id")
    private User user;
    @ColumnInfo(name = "postId")
    private Post post;

    public Comment(Integer commentId, LocalDateTime commentDate, String commentContent, User user, Post post) {
        this.commentId = commentId;
        this.commentDate = commentDate;
        this.commentContent = commentContent;
        this.user = user;
        this.post = post;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
