package com.example.cleanarchitecturekotlin.domain.usecases

import com.example.cleanarchitecturekotlin.data.Museum
import com.example.cleanarchitecturekotlin.data.repository.MuseumRepository
import com.example.cleanarchitecturekotlin.presenter.framework.OperationCallback

class RepositoryUseCase(private val museumRepo: MuseumRepository) {
    fun fetchMudata(callback: OperationCallback<Museum>){
        museumRepo.fetchMuseums(callback)
    }
}