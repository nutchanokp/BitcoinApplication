package com.nut.cdev.bitcoinapplication.data.model

import com.google.gson.annotations.SerializedName

data class TimeModel(
    @SerializedName("updated")
    var updated: String? = null,
    @SerializedName("updatedISO")
    var updatedISO: String? = null,
    @SerializedName("updateduk")
    var updateduk: String? = null
)
