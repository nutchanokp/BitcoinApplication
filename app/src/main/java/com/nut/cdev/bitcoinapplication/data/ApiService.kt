package com.nut.cdev.bitcoinapplication.data

import com.nut.cdev.bitcoinapplication.data.model.BtcModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("v1/bpi/currentprice.json")
    suspend fun getBtc(): Response<BtcModel>

}