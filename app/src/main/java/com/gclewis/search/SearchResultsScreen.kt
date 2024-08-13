package com.gclewis.search

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun SearchResultsScreen(viewModel: SearchResultsViewModel, modifier: Modifier = Modifier) {
    val searchResults by viewModel.searchResults.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchSearchResults()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (searchResults.isEmpty()) {
            Text(text = "Please wait while we fetch the search results...")
        } else {
            LazyColumn {
                items(searchResults) { searchResult ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = searchResult.title,
                            modifier = Modifier
                                .padding(16.dp),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = searchResult.description,
                            modifier = Modifier
                                .padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}
