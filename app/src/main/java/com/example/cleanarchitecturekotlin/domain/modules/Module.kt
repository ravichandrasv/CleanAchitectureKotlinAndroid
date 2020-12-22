package com.example.cleanarchitecturekotlin.domain.modules

import com.example.cleanarchitecturekotlin.presenter.framework.ApiClient
import org.koin.dsl.module


val modulecollection = module {


    single {
        ApiClient.build()
    }
    single {
        ApiClient.interceptor()
    }

}