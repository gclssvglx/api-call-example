package com.gclewis.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SearchResultsViewModel : ViewModel() {
    val isLoading: Boolean = false
    var searchTerm: String = "taxes"
    private val repository = SearchResultsRepository()
    private val _results = MutableLiveData<List<SearchResult>>()

    val searchResults: LiveData<List<SearchResult>> = _results

    fun fetchSearchResults() {
        viewModelScope.launch {
            try {
                val results = repository.getSearchResults(searchTerm, 6)
                _results.value = results.results
            } catch (e: Exception) {
                println("Error fetching: ${e.message}")
            }
        }
    }

    fun onSearchTermChange(s: String) {
        searchTerm = s
    }

    fun onSearch(s: String) {
        fetchSearchResults()
    }
}
