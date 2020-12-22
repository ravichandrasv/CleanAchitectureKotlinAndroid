package com.example.cleanarchitecturekotlin.domain.usecases

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturekotlin.datas.MuseumRepository


class ViewModelFactory(private val repository: MuseumRepository,) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MuseumViewModel(repository) as T
    }
}