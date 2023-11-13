package com.example.androidrealestateproject.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.androidrealestateproject.entity.Post;

import java.util.List;

@Dao
public interface PostDao {

    @Insert
    void insertrecord(Post posts);

    @Query("SELECT EXISTS(SELECT * FROM Post WHERE postid = :postId)")
    Boolean is_exist(int postId);


    @Query("SELECT * FROM Post")
    List<Post> getallposts();

    @Query("DELETE FROM Post WHERE postid = :id")
    void deleteById(int id);
   @Query("UPDATE Post SET title = :name, postContent=:content WHERE postid = :id")
    void updateById(int id, String name, String content);//int id, String name, String content
}

