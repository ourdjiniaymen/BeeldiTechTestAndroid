package com.example.beelditechtest.presentation.navigation

sealed class Screen(val route: String) {
    object EquipmentList : Screen("equipment_list")

    object EquipmentDetails : Screen("equipment_details/{id}") {
        fun createRoute(id: String) = "equipment_details/$id"
    }
}
