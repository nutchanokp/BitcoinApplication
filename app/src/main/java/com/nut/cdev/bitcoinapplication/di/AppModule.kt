package com.nut.cdev.bitcoinapplication.di

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.nut.cdev.bitcoinapplication.SHARED_PREFERENCES_NAME
import com.nut.cdev.bitcoinapplication.data.cache.MainPreference
import com.nut.cdev.bitcoinapplication.data.cache.PreferenceManager
import com.nut.cdev.bitcoinapplication.router.MainRouter
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { createSecurePreferences(androidContext()) }
    single { providePreference(get()) }
    single { providePreferenceManager(get()) }

}

fun createSecurePreferences(context: Context): SharedPreferences =
    context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

fun providePreference(sharedPreferences: SharedPreferences): MainPreference {
    return MainPreference(sharedPreferences)
}

fun providePreferenceManager(mainPreference: MainPreference): PreferenceManager {
    return PreferenceManager(mainPreference)
}

