package com.nut.cdev.bitcoinapplication.data

import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): Response<List<String>> = apiService.getUsers()

}