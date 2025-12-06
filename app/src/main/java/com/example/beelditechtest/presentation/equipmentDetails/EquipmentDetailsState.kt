package com.example.beelditechtest.presentation.equipmentDetails

import com.example.beelditechtest.domain.model.Equipment

data class EquipmentDetailsState(
    val equipment: Equipment? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
