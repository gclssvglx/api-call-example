package com.gclewis.search

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SearchResultsRetrofitInstance {
    private const val BASE_URL = "https://www.gov.uk"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val searchResultsService: SearchResultsService by lazy {
        retrofit.create(SearchResultsService::class.java)
    }
}
