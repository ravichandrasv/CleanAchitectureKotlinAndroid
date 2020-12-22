package com.example.cleanarchitecturekotlin.presenter.commons

import android.app.Application
import com.example.cleanarchitecturekotlin.domain.modules.modulecollection
import org.koin.core.context.startKoin

class App :Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(modulecollection)
        }

    }
}