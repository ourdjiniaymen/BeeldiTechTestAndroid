package com.example.beelditechtest.di

import com.example.beelditechtest.presentation.equipmentDetails.EquipmentDetailsViewModel
import com.example.beelditechtest.presentation.equipmentList.EquipmentListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule =
    module {
        viewModel { EquipmentListViewModel(get()) }
        viewModel { (id: String) ->
            EquipmentDetailsViewModel(get(), id)
        }
    }
