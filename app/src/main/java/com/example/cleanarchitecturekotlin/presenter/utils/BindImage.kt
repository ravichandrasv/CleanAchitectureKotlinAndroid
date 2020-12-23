package com.example.cleanarchitecturekotlin.presenter.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

open class BindImage {
    open fun bindGlideImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url).into(imageView)
    }
}