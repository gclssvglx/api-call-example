package com.gclewis.space

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AstrosInSpaceScreen(viewModel: AstrosInSpaceViewModel, modifier: Modifier = Modifier) {
    val astrosInSpace by viewModel.astros.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchAstros()
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (astrosInSpace.isEmpty()) {
            Text(text = "Loading...")
        } else {
            LazyColumn {
                items(astrosInSpace) { astro ->
                    Card(
                        modifier = Modifier.padding(8.dp).fillMaxWidth()
                    ) {
                        Text(
                            text = astro.name,
                            modifier = Modifier
                                .padding(16.dp),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = astro.craft,
                            modifier = Modifier
                                .padding(16.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}
