package com.example.beelditechtest

data class EquipmentListState(
    val equipments: List<Equipment> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)