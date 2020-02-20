package com.example.retrofitimageloading;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit;
    private static String BASE_URL="https://jsonplaceholder.typicode.com/";

    public static  Retrofit getInstance(){
       // Gson gson = new GsonBuilder().serializeNulls().create();
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
