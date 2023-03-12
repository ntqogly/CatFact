package com.example.catfact.api

import com.example.catfact.models.CatBreeds
import com.example.catfact.models.CatFact
import com.example.catfact.models.CatFacts
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("fact")
    suspend fun loadCatFact(
        @Query(QUERY_PARAM_MAX_LENGTH) maxLength: Int = 150
    ): CatFact

    @GET("facts")
    suspend fun loadListOfCatFacts(
        @Query(QUERY_PARAM_MAX_LENGTH) maxLength: Int = 100,
        @Query(QUERY_PARAM_LIMIT) limit: Int = 2
    ): CatFacts

    @GET("breeds")
    suspend fun loadCatBreeds(
        @Query(QUERY_PARAM_LIMIT) limit: Int = 2
    ): CatBreeds

    companion object {
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_MAX_LENGTH = "max_length"
    }

}