package com.example.beelditechtest.presentation.equipmentDetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InfoSectionCard(
    modifier: Modifier = Modifier,
    title: String,
    leftInfo: String,
    rightInfo: String,
    leftInfoColor: Color = Color.Black,
    rightInfoColor: Color = Color.Black,
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
        ) {
            Text(title, style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = leftInfo,
                    style = MaterialTheme.typography.bodyLarge,
                    color = leftInfoColor,
                )
                Text(
                    text = rightInfo,
                    style = MaterialTheme.typography.bodyLarge,
                    color = rightInfoColor,
                )
            }
        }
    }
}
