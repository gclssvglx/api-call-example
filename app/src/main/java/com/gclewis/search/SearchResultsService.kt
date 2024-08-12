package com.gclewis.search

import retrofit2.http.GET
import retrofit2.http.Query

interface SearchResultsService {
    @GET("/api/search.json")
    suspend fun getSearchResults(
        @Query("q") searchTerm: String,
        @Query("count") count: Int = 4
    ): SearchResults
}
