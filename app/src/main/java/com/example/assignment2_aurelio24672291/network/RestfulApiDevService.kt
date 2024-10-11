package com.example.assignment2_aurelio24672291.network

import com.vu.androidbasicapp.home.data.ResponseItem
import retrofit2.http.GET

interface RestfulApiDevService {

    @GET("objects")
    suspend fun getAllObjects(): List<ResponseItem>
}