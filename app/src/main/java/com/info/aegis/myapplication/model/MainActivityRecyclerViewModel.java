package com.info.aegis.myapplication.model;

public class MainActivityRecyclerViewModel {
    private String name;

    public MainActivityRecyclerViewModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
