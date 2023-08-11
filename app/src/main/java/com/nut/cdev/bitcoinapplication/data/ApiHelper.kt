package com.nut.cdev.bitcoinapplication.data

import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<String>>
}