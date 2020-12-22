package com.example.cleanarchitecturekotlin.domain.di

import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturekotlin.presenter.framework.ApiClient
import com.example.cleanarchitecturekotlin.presenter.framework.MuseumRemoteDataSource
import com.example.cleanarchitecturekotlin.datas.MuseumDataSource
import com.example.cleanarchitecturekotlin.datas.MuseumRepository
import com.example.cleanarchitecturekotlin.domain.usecases.ViewModelFactory


object Injection {

    private val museumDataSource: MuseumDataSource = MuseumRemoteDataSource(ApiClient)
    private val museumRepository = MuseumRepository(museumDataSource)
    private val museumViewModelFactory = ViewModelFactory(museumRepository)


    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return museumViewModelFactory
    }
}