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
import com.gclewis.space.AstrosInSpaceScreen
import com.gclewis.space.AstrosInSpaceViewModel
import com.gclewis.ui.theme.APICallExampleTheme
import java.net.HttpURLConnection
import java.net.URI

class MainActivity : ComponentActivity() {
//    private val viewModel: AstrosInSpaceViewModel by viewModels()
    private val viewModel: SearchResultsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            APICallExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    whoIsInSpace()
//                    AstrosInSpaceScreen(viewModel)
                    SearchResultsScreen(viewModel)
                }
            }
        }
    }
}

private fun whoIsInSpace() {
    val url = URI.create("http://api.open-notify.org/astros.json").toURL()
    val conn = url.openConnection() as HttpURLConnection

    conn.requestMethod = "GET"
    conn.connect()

    val responseCode = conn.responseCode
    if (responseCode == HttpURLConnection.HTTP_OK) {
        val response = conn.inputStream.bufferedReader().use { it.readText() }
        println(response)
    } else {
        throw RuntimeException("HTTP GET request failed with error code: $responseCode")
    }
}
