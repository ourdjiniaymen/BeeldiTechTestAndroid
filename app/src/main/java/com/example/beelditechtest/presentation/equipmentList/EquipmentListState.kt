package com.example.beelditechtest.presentation.equipmentList

import com.example.beelditechtest.domain.model.Equipment

data class EquipmentListState(
    val equipments: List<Equipment> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)