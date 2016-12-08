package com.vondear.tools;

/**
 * Created by vonde on 2016/11/13.
 */

public class MainItem {

    private String name;

    private int image;

    private Class activity;

    public MainItem(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}