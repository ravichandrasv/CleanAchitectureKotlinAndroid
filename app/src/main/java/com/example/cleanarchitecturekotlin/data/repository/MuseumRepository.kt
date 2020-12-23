package com.example.cleanarchitecturekotlin.data.repository

import com.example.cleanarchitecturekotlin.data.Museum
import com.example.cleanarchitecturekotlin.data.MuseumDataSource
import com.example.cleanarchitecturekotlin.presenter.framework.OperationCallback


class MuseumRepository(private val museumDataSource: MuseumDataSource) {

    fun fetchMuseums(callback: OperationCallback<Museum>) {
        museumDataSource.retrieveMuseums(callback)
    }


}