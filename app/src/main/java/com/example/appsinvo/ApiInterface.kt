package com.example.appsinvo

import com.example.appsinvo.models.FakeDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")

    suspend fun getFakeApiData(): Response<List<FakeDataModel>>

}