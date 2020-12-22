package com.example.cleanarchitecturekotlin.datas

import com.example.cleanarchitecturekotlin.presenter.framework.OperationCallback


class MuseumRepository(private val museumDataSource: MuseumDataSource) {

    fun fetchMuseums(callback: OperationCallback<Museum>) {
        museumDataSource.retrieveMuseums(callback)
    }


}