package com.example.cleanarchitecturekotlin.data

import java.io.Serializable


data class Museum(val id: Int, val body:String,val title: String, val url: String) : Serializable