package com.example.androidrealestateproject.helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.androidrealestateproject.MainActivity;
import com.example.androidrealestateproject.entity.User;

import java.util.HashMap;

public class SessionManagement {
    SharedPreferences pref;

    SharedPreferences.Editor editor;

    Context _context;

    int Private_mode = 0;

    private static final String PREF_NAME = "RightCleaner ";

    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String KEY_EMAIL = "email";
    public static final String KEY_ID = "id";

    public static final String KEY_PASSWORD = "password";
    public static final String KEY_SERVICE_CHOICE = "service_choice";
    public static final String KEY_PROFILE="profile";

    public SessionManagement (Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, Private_mode);
        editor = pref.edit();
    }

    public void createLoginSession(String email, String password,int id){
        editor.putBoolean(IS_LOGIN,true);

        editor.putString(KEY_EMAIL, email);
        editor.putInt(KEY_ID, id);
        editor.putString(KEY_PASSWORD, password);

        editor.commit();
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void checkLogin(){
        if(!this.isLoggedIn()){
            Intent i = new Intent(_context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            _context.startActivity(i);
        }
    }

    public HashMap<String , Object> getUserDetails(){
        HashMap<String, Object> user = new HashMap<String, Object>();

        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL,null));
        user.put(KEY_ID, pref.getInt(KEY_ID,-1));
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD,null));

        return user;
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        _context.startActivity(i);
    }

    public void setServiceChoiceSession(String service){
        editor.putString(KEY_SERVICE_CHOICE,service);
        editor.commit();
    }
    public HashMap<String , String> getServiceChoice(){
        HashMap<String, String> service = new HashMap<String, String>();
        service.put(KEY_SERVICE_CHOICE,pref.getString(KEY_SERVICE_CHOICE,null));
        return service;
    }
    public void setProfile(User user){
        editor.putString(KEY_PROFILE,user.getEmail());
        editor.commit();
    }
    public HashMap<String,String> getProfile(){
        HashMap<String,String> profile=new HashMap<String,String>();
        profile.put(KEY_PROFILE,pref.getString(KEY_PROFILE,""));
        return profile;
    }
    public void  cleanProfile(){
        editor.remove(KEY_PROFILE);
        editor.commit();
    }





}
