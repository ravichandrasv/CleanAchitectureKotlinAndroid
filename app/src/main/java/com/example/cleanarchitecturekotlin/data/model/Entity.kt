package com.example.cleanarchitecturekotlin.presenter.framework

import com.example.cleanarchitecturekotlin.data.Museum


data class MuseumResponse(val status: Int?, val msg: String?, val data: List<Museum>?) {
}