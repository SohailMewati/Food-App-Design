package com.example.appsinvo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FoodRetrofit {

    fun getInstance(): ApiInterface {

        return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
}