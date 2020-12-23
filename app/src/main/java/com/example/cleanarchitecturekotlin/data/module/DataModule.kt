package com.example.cleanarchitecturekotlin.data.module

import com.example.cleanarchitecturekotlin.data.repository.MuseumRepository
import com.example.cleanarchitecturekotlin.presenter.framework.ApiClient
import com.example.cleanarchitecturekotlin.presenter.framework.MuseumRemoteDataSource

import org.koin.dsl.module

val datamodule= module{
    single {
        MuseumRepository(MuseumRemoteDataSource(ApiClient))
    }
}