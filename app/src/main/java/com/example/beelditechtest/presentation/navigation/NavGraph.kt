package com.example.beelditechtest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.beelditechtest.presentation.equipmentDetails.EquipmentDetailsScreen
import com.example.beelditechtest.presentation.equipmentList.EquipmentListScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(modifier = modifier, navController = navController, startDestination = Screen.EquipmentList.route) {
        composable(Screen.EquipmentList.route) {
            EquipmentListScreen(
                onEquipmentClick = { id ->
                    navController.navigate(Screen.EquipmentDetails.createRoute(id))
                },
            )
        }

        composable(Screen.EquipmentDetails.route) { backEntry ->
            val id: String = backEntry.arguments?.getString("id")!!
            EquipmentDetailsScreen(id = id)
        }
    }
}
