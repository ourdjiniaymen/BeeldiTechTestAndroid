package com.example.beelditechtest.presentation.equipmentList

import com.example.beelditechtest.data.model.EquipmentEntity

data class EquipmentListState(
    val equipments: List<EquipmentEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)