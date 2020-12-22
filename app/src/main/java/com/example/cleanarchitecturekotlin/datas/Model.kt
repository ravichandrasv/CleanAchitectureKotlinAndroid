package com.example.cleanarchitecturekotlin.datas

import java.io.Serializable


//data class Museum(val id: Int, val name: String, val photo: String) : Serializable

data class Museum(val id: Int, val body:String,val title: String, val url: String) : Serializable