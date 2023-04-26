package com.devtides.androidarchitectures.model;

import com.google.gson.annotations.SerializedName;

public class Test {

    @SerializedName("AF")
    public AF data;

    public class AF {
        @SerializedName("country_name")
        public String country_name;
        @SerializedName("dialling_code")
        public String dialling_code;

    }
}
