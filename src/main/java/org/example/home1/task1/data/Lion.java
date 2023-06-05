package org.example.home1.task1.data;

import org.example.home1.task1.IsHunter;

public class Lion extends Animal implements IsHunter {

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void startHunt() {
        System.out.println(this + " start hunting!");
    }

}
