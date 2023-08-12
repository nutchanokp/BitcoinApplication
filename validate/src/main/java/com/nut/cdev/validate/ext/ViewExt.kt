package com.nut.cdev.validate.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadImage(resId: Int) {
    try {
        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
        Glide.with(context).load(resId).apply(requestOptions).into(this)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}
