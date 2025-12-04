package com.example.beelditechtest

import android.app.Application
import com.example.beelditechtest.di.dataModule
import com.example.beelditechtest.di.domainModule
import com.example.beelditechtest.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BeeldiTechTestApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialiser Koin
        startKoin {


            // Contexte Android
            androidContext(this@BeeldiTechTestApp)

            // Modules de dépendances
            modules(
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}