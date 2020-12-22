package com.example.cleanarchitecturekotlin.presenter.framework

import com.example.cleanarchitecturekotlin.datas.Museum


data class MuseumResponse(val status: Int?, val msg: String?, val data: List<Museum>?) {
    fun isSuccess(): Boolean = (status == 200)
}