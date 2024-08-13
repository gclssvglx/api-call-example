package com.gclewis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.gclewis.search.SearchResultsScreen
import com.gclewis.search.SearchResultsViewModel
import com.gclewis.ui.theme.APICallExampleTheme

class MainActivity : ComponentActivity() {
    private val viewModel: SearchResultsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            APICallExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SearchResultsScreen(viewModel)
                }
            }
        }
    }
}
