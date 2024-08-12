package com.gclewis.space

import retrofit2.http.GET

interface AstrosInSpaceService {
    @GET("/astros.json")
    suspend fun getAstrosInSpace(): AstrosInSpace
}
