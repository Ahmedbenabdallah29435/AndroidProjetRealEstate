package com.example.androidrealestateproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.androidrealestateproject.entity.Post;
import com.example.androidrealestateproject.entity.User;

import java.util.List;

@Dao
public interface PostDAO {
    @Query("SELECT * FROM post")
    List<Post> getAll();
    @Query("SELECT * FROM post  WHERE category = 'WorldNews'")
    List<Post> getWorldNewsPost();
    @Query("SELECT * FROM post  WHERE category = 'LocalNews'")
    List<Post> getLocalNewsPost();
    @Query("SELECT p.* FROM post as  p WHERE postId=:postId")
    Post getPostId(int postId);
    @Insert
    void addPost(Post post);
    @Update
    //@Query("UPDATE User SET first_name = :fname, last_name=:lname WHERE uid = :id")
   // void updateById(int id, String fname, String lname);
    void updatePost(Post post);
    @Delete
    void deletePost(Post post);
}
