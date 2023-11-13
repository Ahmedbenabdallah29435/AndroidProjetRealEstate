package com.example.androidrealestateproject.helper;

public enum Role {
    SIMPLE_USER ("simpleUser"),
    Service_Provider ("serviceProvider");
    private final String label;
    private Role(String label){
        this.label=label;
    }
    public String toString(){
        return this.label;
    }

}
