package com.example.cleanarchitecturekotlin.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturekotlin.presenter.framework.OperationCallback
import com.example.cleanarchitecturekotlin.data.Museum
import com.example.cleanarchitecturekotlin.domain.usecases.RepositoryUseCase


class MuseumViewModel(private val repository: RepositoryUseCase) : ViewModel() {

    private val _museums = MutableLiveData<List<Museum>>().apply { value = emptyList() }
    val museums: LiveData<List<Museum>> = _museums


    fun loadMuseums() {
        repository.fetchMudata(object : OperationCallback<Museum> {
            override fun onError(error: String?) {
            }

            override fun onSuccess(data: List<Museum>?) {
                    _museums.value = data

            }
        })
    }

}