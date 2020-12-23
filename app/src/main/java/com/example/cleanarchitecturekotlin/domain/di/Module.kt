package com.example.cleanarchitecturekotlin.domain.modules

import com.example.cleanarchitecturekotlin.presenter.viewmodel.MuseumViewModel
import com.example.cleanarchitecturekotlin.domain.usecases.RepositoryUseCase
import com.example.cleanarchitecturekotlin.presenter.framework.ApiClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val modulecollection = module {


    single {
        ApiClient.build()
    }
    single {
        ApiClient.interceptor()
    }
    factory {
        RepositoryUseCase(get())
    }
    viewModel {
        MuseumViewModel(get())
    }



}