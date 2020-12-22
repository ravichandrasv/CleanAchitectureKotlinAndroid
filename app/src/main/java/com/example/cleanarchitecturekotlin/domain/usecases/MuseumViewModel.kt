package com.example.cleanarchitecturekotlin.domain.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturekotlin.presenter.framework.OperationCallback
import com.example.cleanarchitecturekotlin.datas.Museum
import com.example.cleanarchitecturekotlin.datas.MuseumRepository


class MuseumViewModel(private val repository: MuseumRepository) : ViewModel() {

    private val _museums = MutableLiveData<List<Museum>>().apply { value = emptyList() }
    val museums: LiveData<List<Museum>> = _museums


    fun loadMuseums() {
        repository.fetchMuseums(object : OperationCallback<Museum> {
            override fun onError(error: String?) {
            }

            override fun onSuccess(data: List<Museum>?) {
                    _museums.value = data

            }
        })
    }

}