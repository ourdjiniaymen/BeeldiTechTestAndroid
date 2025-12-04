package com.example.beelditechtest.presentation.equipmentList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.beelditechtest.presentation.equipmentList.EquipmentListViewModel
import com.example.beelditechtest.data.model.EquipmentEntity
import com.example.beelditechtest.presentation.equipmentList.components.EquipmentCard

@Composable
fun EquipmentListScreen(
    viewModel: EquipmentListViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()

    when {
        state.isLoading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        state.error != null -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Erreur: ${state.error}",
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
        else -> {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(state.equipmentEntities) { equipment ->
                    EquipmentCard(
                        equipmentEntity = equipment,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}


