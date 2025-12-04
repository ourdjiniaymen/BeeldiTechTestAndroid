package com.example.beelditechtest.di

import com.example.beelditechtest.domain.usecase.GetEquipmentsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetEquipmentsUseCase(get()) }
}