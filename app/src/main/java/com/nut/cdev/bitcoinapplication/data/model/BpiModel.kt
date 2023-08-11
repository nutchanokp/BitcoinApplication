package com.nut.cdev.bitcoinapplication.data.model

import com.google.gson.annotations.SerializedName

data class BpiGroupModel(

    @SerializedName("disclaimer")
    var disclaimer: String? = null,
    @SerializedName("USD")
    var USD: BpiModel? = null,
    @SerializedName("GBP")
    var GBP: BpiModel? = null,
    @SerializedName("EUR")
    var EUR: BpiModel? = null,

    )


data class BpiModel(
    @SerializedName("code")
    var code: String? = null,
    @SerializedName("symbol")
    var symbol: String? = null,
    @SerializedName("rate")
    var rate: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("rate_float")
    var rate_float: Float? = null,

    )
