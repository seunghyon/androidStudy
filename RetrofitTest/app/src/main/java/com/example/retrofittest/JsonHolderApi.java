package com.example.retrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonHolderApi {

    String BASE_URL = "http://13.124.242.42/project/";

    @GET("allusers.php")
    Call<List<Post>> login(@Query("id") String id,
                          @Query("nickName") String nickName);

    @GET("update.php")
    Call<Post> update(@Query("id") String id,
                           @Query("nickName") String nickName);
}
