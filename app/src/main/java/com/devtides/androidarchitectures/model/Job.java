package com.devtides.androidarchitectures.model;

public class Job {

    public Job(int id, String job) {
        this.id = id;
        this.job = job;
    }

    private int id;
    private String job;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
