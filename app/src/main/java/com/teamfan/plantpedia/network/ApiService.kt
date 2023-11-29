package com.teamfan.plantpedia.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/volumes")
    fun getPlantBooks(
        @Query("q") q: String ="subject:plants",
        @Query("projection") projection: String = "lite"
    ): Call<BookResponse>
}