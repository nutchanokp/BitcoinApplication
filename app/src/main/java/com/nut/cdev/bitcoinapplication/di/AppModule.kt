package com.nut.cdev.bitcoinapplication.di

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.nut.cdev.bitcoinapplication.SHARED_PREFERENCES_NAME
import com.nut.cdev.bitcoinapplication.data.ApiHelper
import com.nut.cdev.bitcoinapplication.data.ApiHelperImpl
import com.nut.cdev.bitcoinapplication.data.cache.MainPreference
import com.nut.cdev.bitcoinapplication.data.cache.PreferenceManager
import com.nut.cdev.bitcoinapplication.router.MainRouter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { createSecurePreferences(androidContext()) }
    single { providePreference(get()) }
    single { providePreferenceManager(get()) }
    single { provideRouter(AppCompatActivity()) }

    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }
}

fun createSecurePreferences(context: Context): SharedPreferences =
    context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

fun providePreference(sharedPreferences: SharedPreferences): MainPreference {
    return MainPreference(sharedPreferences)
}

fun providePreferenceManager(mainPreference: MainPreference): PreferenceManager {
    return PreferenceManager(mainPreference)
}

private fun provideRouter(appCompatActivity: AppCompatActivity) = MainRouter(appCompatActivity)

