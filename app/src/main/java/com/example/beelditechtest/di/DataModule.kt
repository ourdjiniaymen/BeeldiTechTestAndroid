package com.example.beelditechtest.di

import com.example.beelditechtest.data.datasource.EquipmentDataSource
import com.example.beelditechtest.data.repository.EquipmentRepositoryImpl
import com.example.beelditechtest.domain.repository.EquipmentRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule =
    module {
        // DataSource (single = singleton)
        single { EquipmentDataSource(androidContext()) }

        // Repository (single = singleton)
        single<EquipmentRepository> { EquipmentRepositoryImpl(get()) }
    }
