package com.example.androidrealestateproject.helper;

public enum ServiceCategory {
    CONSTRUCTOR("Contructor"),
    RENTAL("Rental"),
    BLOGGER("blogger");
    private final String label;
    private ServiceCategory(String label){
        this.label=label;
    }
    public String toString(){
        return this.label;
    }




}
