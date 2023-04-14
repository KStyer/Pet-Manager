package com.kstyer.models;

public class Cat extends Pet{
    public Cat(String newName) {
        super(newName);
    }
    public String getType() {
        return "\uD83D\uDC31";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
