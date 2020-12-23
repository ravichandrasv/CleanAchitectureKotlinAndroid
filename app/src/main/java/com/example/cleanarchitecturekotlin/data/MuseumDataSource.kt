package com.example.cleanarchitecturekotlin.data

import com.example.cleanarchitecturekotlin.presenter.framework.OperationCallback


interface MuseumDataSource {

    fun retrieveMuseums(callback: OperationCallback<Museum>)
    fun cancel()
}