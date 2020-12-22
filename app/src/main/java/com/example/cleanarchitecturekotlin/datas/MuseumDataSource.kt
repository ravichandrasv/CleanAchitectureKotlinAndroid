package com.example.cleanarchitecturekotlin.datas

import com.example.cleanarchitecturekotlin.presenter.framework.OperationCallback


interface MuseumDataSource {

    fun retrieveMuseums(callback: OperationCallback<Museum>)
    fun cancel()
}