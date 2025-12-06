package com.example.beelditechtest.presentation.equipmentDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.beelditechtest.domain.model.Equipment
import com.example.beelditechtest.presentation.equipmentDetails.components.InfoSectionCard
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun EquipmentDetailsScreen(
    modifier: Modifier = Modifier,
    id: String,
    viewModel: EquipmentDetailsViewModel = koinViewModel(parameters = { parametersOf(id) }),
) {
    val state by viewModel.state.collectAsState()

    when {
        state.isLoading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        }

        state.error != null -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Erreur: ${state.error}",
                    color = MaterialTheme.colorScheme.error,
                )
            }
        }

        state.equipment == null -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Équipement introuvable",
                    color = MaterialTheme.colorScheme.error,
                )
            }
        }

        else -> {
            val equipment: Equipment = state.equipment!!
            Column(
                modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                Text(equipment.name, style = MaterialTheme.typography.headlineSmall)
                Spacer(Modifier.height(16.dp))
                InfoSectionCard(
                    title = "Informations Générales",
                    leftInfo = "Marque : ${equipment.brand}",
                    rightInfo = equipment.location,
                    rightInfoColor = Color.Red,
                )
                Spacer(Modifier.height(12.dp))
                InfoSectionCard(
                    title = "Informations Techniques",
                    leftInfo = "Série : ${equipment.serialNumber}",
                    rightInfo = "Modèle : ${equipment.model}",
                )
            }
        }
    }
}
