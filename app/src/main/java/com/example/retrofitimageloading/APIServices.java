package com.example.retrofitimageloading;

import com.example.retrofitimageloading.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices {

    @GET("photos")
    Call<List<Post>> getPostList();

}
