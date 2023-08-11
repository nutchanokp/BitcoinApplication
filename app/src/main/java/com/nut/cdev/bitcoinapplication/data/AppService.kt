package com.nut.cdev.bitcoinapplication.data

import retrofit2.Call
import retrofit2.http.*

interface AppService {

    @GET("languages")
    fun getUIText(@Query("type") type: String): Call<MutableList<String>>

    @POST("auth/fcmtoken")
    @FormUrlEncoded
    fun updateFcmToken(@FieldMap param: Map<String, String>): Call<String>

}