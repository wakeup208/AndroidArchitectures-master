package com.devtides.androidarchitectures.api;

import com.devtides.androidarchitectures.model.Currentcy;
import com.devtides.androidarchitectures.model.Test;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    //https://api.apilayer.com/number_verification/countries?apikey=jYWqib9dZODhj80emajRZ8eYuss0AU7K
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiService = new Retrofit.Builder().baseUrl("https://api.apilayer.com/")
                                                  .addConverterFactory(GsonConverterFactory.create(gson))
                                                  .build().create(ApiService.class);
//    @GET("api/live")
//    Call<Currentcy> convertUsdToVnd(@Query("access_key") String access_key,
//                                    @Query("currencies") String currencies,
//                                    @Query("source") String source,
//                                    @Query("format") int format);

    @GET("number_verification/countries")
    Call<Test> convertUsdToVnd(@Query("apikey") String apikey);
}


