package com.devtides.androidarchitectures;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.devtides.androidarchitectures.api.ApiClient;
import com.devtides.androidarchitectures.api.ApiInterface;
import com.devtides.androidarchitectures.api.ApiService;
import com.devtides.androidarchitectures.model.Currentcy;
import com.devtides.androidarchitectures.model.Favorite;
import com.devtides.androidarchitectures.model.Job;
import com.devtides.androidarchitectures.model.MultipleResource;
import com.devtides.androidarchitectures.model.Test;
import com.devtides.androidarchitectures.model.User;
import com.devtides.androidarchitectures.model.UserList;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txt1, txt2, txt3;
    Button btnCall;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act);

        Job job = new Job(1,"Coder");
        List<Favorite> favorites = new ArrayList<>();
        favorites.add(new Favorite(1, "Football"));
        favorites.add(new Favorite(2, "Game"));
        favorites.add(new Favorite(3, "Coding"));

        //User user = new User(1, "Thuc", true, job, favorites);
        //Gson gson = new Gson();
       // String strJson = gson.toJson(user);
        //Log.e("Thuc", strJson);

        txt1 = findViewById(R.id.txtCurr);
        txt2 = findViewById(R.id.txtUsd);
        txt3 = findViewById(R.id.txtVnd);

        btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _callAPI();
            }
        });

    }

    private void _callAPI() {
       ApiService.apiService.convertUsdToVnd("jYWqib9dZODhj80emajRZ8eYuss0AU7K").enqueue(new Callback<Test>() {
           @Override
           public void onResponse(Call<Test> call, Response<Test> response) {
               Test test = response.body();

               if(test != null) {
                   txt1.setText(test.data.country_name);
                   txt2.setText(test.data.dialling_code);
                   Log.d("Thuc", test.data.country_name);
                   Log.d("Thuc", test.data.dialling_code);
               }
           }

           @Override
           public void onFailure(Call<Test> call, Throwable t) {

           }
       });
    }
    private void callAPI() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<MultipleResource> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {
                Log.d("TAG",response.code()+"");

                String displayResponse = "";

                MultipleResource resource = response.body();
                Integer text = resource.page;
                Integer total = resource.total;
                Integer totalPages = resource.totalPages;
                List<MultipleResource.Datum> datumList = resource.data;

                displayResponse += text + " Page\n" + total + " Total\n" + totalPages + " Total Pages\n";

                for (MultipleResource.Datum datum : datumList) {
                    displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
                }

                txt1.setText(displayResponse);
            }

            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {
                call.cancel();
            }
        });

        Call<UserList> call2 = apiInterface.doGetUserList("2");
        call2.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {

                UserList userList = response.body();
                Integer text = userList.page;
                Integer total = userList.total;
                Integer totalPages = userList.totalPages;
                List<UserList.Datum> datumList = userList.data;
                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
                Log.e("Thuc", text + " page\n" + total + " total\n" + totalPages + " totalPages\n");
                String displayResponse = "";

                Log.e("Thuc", text + " page\n" + total + " total\n" + totalPages + " totalPages\n");
                for (UserList.Datum datum : datumList) {
                    displayResponse += "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.email +"\n";
                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.email, Toast.LENGTH_SHORT).show();
                }

                txt2.setText(displayResponse);

            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });

        Call<UserList> call22 = apiInterface.doGetDelay("3");
        call22.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {

                UserList userList = response.body();
                Integer text = userList.page;
                Integer total = userList.total;
                Integer totalPages = userList.totalPages;
                List<UserList.Datum> datumList = userList.data;
                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
                Log.e("Thuc", text + " page\n" + total + " total\n" + totalPages + " totalPages\n");
                String displayResponse = "";

                Log.e("Thuc", text + " page\n" + total + " total\n" + totalPages + " totalPages\n");
                for (UserList.Datum datum : datumList) {
                    displayResponse += "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.email +"\n";
                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.email, Toast.LENGTH_SHORT).show();
                }

                txt3.setText(displayResponse);

            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });

        /**
         POST name and job Url encoded.
         **/
        Call<UserList> call3 = apiInterface.doCreateUserWithField("eve.holt@reqres.in","pistol");
        call3.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                UserList userList = response.body();
                Integer text = userList.page;
                Integer total = userList.total;
                Integer totalPages = userList.totalPages;
                List<UserList.Datum> datumList = userList.data;
                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
                Log.d("Thuc3", text + " page\n" + total + " total\n" + totalPages + " totalPages\n");
                String displayResponse = "";

                for (UserList.Datum datum : datumList) {
                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.email, Toast.LENGTH_SHORT).show();
                    displayResponse += "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.email +"\n";
                }

                txt3.setText(displayResponse);

            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });

    }
}
