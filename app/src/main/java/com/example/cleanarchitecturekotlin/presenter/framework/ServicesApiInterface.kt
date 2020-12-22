package com.example.cleanarchitecturekotlin.presenter.framework

import com.example.cleanarchitecturekotlin.presenter.utils.Constants.GET_MUSEUM_LIST
import retrofit2.Call
import retrofit2.http.GET

interface ServicesApiInterface {
    @GET(GET_MUSEUM_LIST)
    fun museums(): Call<MuseumResponse>
}