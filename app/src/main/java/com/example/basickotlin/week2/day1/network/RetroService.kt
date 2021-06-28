package com.example.basickotlin.week2.day1.network

import com.example.basickotlin.week2.day1.model.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query : String): RecyclerList
}