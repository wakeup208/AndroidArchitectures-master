package com.devtides.androidarchitectures.model;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("name")
    public String countryName;

    @SerializedName("capital")
    public String capital;
}
