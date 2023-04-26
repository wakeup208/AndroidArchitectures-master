package com.devtides.androidarchitectures.model;

import com.google.gson.annotations.SerializedName;

public class Quote {

    @SerializedName("USDVND")
    private float usdVnd;

    public Quote(float USDVND) {
        this.usdVnd = USDVND;
    }

    public float getUsdVnd() {
        return usdVnd;
    }

    public void setUsdVnd(float usdVnd) {
        this.usdVnd = usdVnd;
    }
}
