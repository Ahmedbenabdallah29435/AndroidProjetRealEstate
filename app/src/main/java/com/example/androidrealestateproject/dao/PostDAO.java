package com.example.androidrealestateproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.androidrealestateproject.entity.Post;

import java.util.List;

@Dao
public interface PostDAO {
    @Query("SELECT * FROM post")
    List<Post> getAll();
//    @Query("SELECT * FROM post  WHERE postDate = 'WorldNews'")
//    List<Post> getMeetByEmailServiceUser(String emailServiceUser);
//    @Query("SELECT r.* FROM post as  r WHERE r.emailSimpleUser=:emailSimpleUser")
//    List<Post> getMeetByEmailSimpleUser(String emailSimpleUser);
    @Insert
    void addPost(Post post);
    @Update
    void updatePost(Post post);
    @Delete
    void deletePost(Post post);
}
