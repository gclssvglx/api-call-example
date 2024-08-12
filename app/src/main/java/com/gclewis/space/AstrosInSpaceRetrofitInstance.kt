package com.gclewis.space

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AstrosInSpaceRetrofitInstance {
    private const val BASE_URL = "http://api.open-notify.org"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val astrosInSpaceService: AstrosInSpaceService by lazy {
        retrofit.create(AstrosInSpaceService::class.java)
    }
}
