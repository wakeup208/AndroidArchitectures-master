package com.devtides.androidarchitectures.model;

public class Favorite {

    public Favorite(int id, String favorite) {
        this.id = id;
        this.favorite = favorite;
    }

    private int id;
    private String favorite;

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
