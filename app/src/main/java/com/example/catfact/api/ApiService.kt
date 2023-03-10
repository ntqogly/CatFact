package com.example.catfact.api

import com.example.catfact.CatFact
import retrofit2.http.GET

interface ApiService {

    @GET("fact?max_length=140")
    suspend fun loadCatFact(): CatFact
}