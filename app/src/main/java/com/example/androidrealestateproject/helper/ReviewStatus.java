package com.example.androidrealestateproject.helper;

public enum ReviewStatus {
    GOOD("Good"),
    AVERAGE("Average"),
    BAD("Bad");
    private final String label;
    private ReviewStatus(String label){
        this.label=label;
    }
    public String toString(){
        return this.label;
    }
}
