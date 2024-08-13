package com.gclewis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gclewis.search.SearchResultsScreen
import com.gclewis.search.SearchResultsViewModel
import com.gclewis.ui.theme.APICallExampleTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    private val viewModel: SearchResultsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val searchResults = viewModel.searchResults
        val searchTerm = viewModel.searchTerm
        val isLoading = viewModel.isLoading

        enableEdgeToEdge()
        setContent {
            APICallExampleTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        SearchBar(
                            query = searchTerm,
                            onQueryChange = viewModel::onSearchTermChange,
                            onSearch = viewModel::onSearch,
                            active = false,
                            onActiveChange = {},
                            placeholder = { Text("Search") },
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                            trailingIcon = { Icon(Icons.Default.Clear, contentDescription = null) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) { }
                    }
                ) { innerPadding ->
                    SearchResultsScreen(viewModel, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
