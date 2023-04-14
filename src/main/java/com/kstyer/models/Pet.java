package com.kstyer.models;

public class Pet {
    private String name;
    public Pet(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }
    public String getType() {
        return "?";
    }
}
