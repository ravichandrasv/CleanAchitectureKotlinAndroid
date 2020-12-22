package com.example.cleanarchitecturekotlin.presenter.framework


interface OperationCallback<T> {
    fun onSuccess(data: List<T>?)
    fun onError(error: String?)
}