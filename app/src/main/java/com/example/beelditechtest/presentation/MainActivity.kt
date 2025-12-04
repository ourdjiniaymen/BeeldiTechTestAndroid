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
import com.example.beelditechtest.data.datasource.EquipmentDataSource
import com.example.beelditechtest.presentation.equipmentList.EquipmentListScreen
import com.example.beelditechtest.presentation.equipmentList.EquipmentListViewModel
import com.example.beelditechtest.presentation.theme.BeeldiTechTestTheme
import com.example.beelditechtest.presentation.theme.screenBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataSource = EquipmentDataSource(context = this)
        val viewModel = EquipmentListViewModel(dataSource)
        enableEdgeToEdge()
        setContent {
            BeeldiTechTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize().background(screenBackground)) { innerPadding ->
                    EquipmentListScreen(viewModel, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BeeldiTechTestTheme {
        Greeting("Android")
    }
}