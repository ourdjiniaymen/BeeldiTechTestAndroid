package com.example.beelditechtest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.beelditechtest.presentation.navigation.NavGraph
import com.example.beelditechtest.presentation.theme.BeeldiTechTestTheme
import com.example.beelditechtest.presentation.theme.screenBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            BeeldiTechTestTheme {
                Scaffold(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .background(screenBackground),
                ) { innerPadding ->
                    NavGraph(modifier = Modifier.padding(innerPadding), navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BeeldiTechTestTheme {
        Greeting("Android")
    }
}
