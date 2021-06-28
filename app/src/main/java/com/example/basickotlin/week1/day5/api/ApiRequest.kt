package com.example.basickotlin.week1.day5.api

import retrofit2.http.GET

const val BASE_URL = "https://random.dog"

interface ApiRequest
{
    @GET("/woof.json?ref=applist.fun")
    suspend fun getRandomDog(): ApiData
}