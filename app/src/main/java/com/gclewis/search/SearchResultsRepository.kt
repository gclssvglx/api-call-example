package com.gclewis.search

class SearchResultsRepository {
    private val searchResultsService = SearchResultsRetrofitInstance.searchResultsService

    suspend fun getSearchResults(searchTerm: String, count: Int): SearchResults {
        return searchResultsService.getSearchResults(searchTerm, count)
    }
}
