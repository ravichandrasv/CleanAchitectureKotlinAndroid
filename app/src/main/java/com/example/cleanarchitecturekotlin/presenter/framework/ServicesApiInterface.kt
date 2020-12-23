package com.example.cleanarchitecturekotlin.presenter.framework

import com.example.cleanarchitecturekotlin.presenter.utils.Constants.GET_MUSEUM_LIST
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

open interface ServicesApiInterface {
    @GET(GET_MUSEUM_LIST)
    fun museums(): Observable<MuseumResponse>
}