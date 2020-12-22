package com.example.cleanarchitecturekotlin.domain.usecases

import android.widget.ImageView
import android.widget.Toast

class ItemClick {
    companion object Test {
        fun callClick(imageview:ImageView) {
            Toast.makeText(imageview.context, "clicked", Toast.LENGTH_SHORT).show()
        }
    }
}