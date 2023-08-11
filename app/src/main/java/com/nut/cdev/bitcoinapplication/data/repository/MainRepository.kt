package com.nut.cdev.bitcoinapplication.data.repository

import com.nut.cdev.bitcoinapplication.data.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()

}