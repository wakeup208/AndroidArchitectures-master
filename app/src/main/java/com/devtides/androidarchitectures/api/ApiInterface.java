package com.devtides.androidarchitectures.api;

import com.devtides.androidarchitectures.model.MultipleResource;
import com.devtides.androidarchitectures.model.User;
import com.devtides.androidarchitectures.model.UserList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();

    @POST("/api/users")
    Call<User> createUser(@Body User user);

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @GET("/api/users?")
    Call<UserList> doGetDelay(@Query("delay") String delay);

    @FormUrlEncoded
    @POST("/api/register?")
    Call<UserList> doCreateUserWithField(@Field("email") String name, @Field("password") String job);
}
