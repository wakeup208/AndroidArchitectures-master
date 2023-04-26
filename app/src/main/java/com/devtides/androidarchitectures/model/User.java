package com.devtides.androidarchitectures.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

//    public User(int id, String name, boolean isActive, Job job, List<Favorite> favorites) {
//        this.id = id;
//        this.name = name;
//        this.isActive = isActive;
//        this.job = job;
//        this.favorites = favorites;
//    }
//
//    private int id;
//    private String name;
//    private boolean isActive;
//    private Job job;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public boolean isActive() {
//        return isActive;
//    }
//
//    public void setActive(boolean active) {
//        isActive = active;
//    }
//
//    public Job getJob() {
//        return job;
//    }
//
//    public void setJob(Job job) {
//        this.job = job;
//    }
//
//    public List<Favorite> getFavorites() {
//        return favorites;
//    }
//
//    public void setFavorites(List<Favorite> favorites) {
//        this.favorites = favorites;
//    }
//
//    private List<Favorite> favorites;


    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
