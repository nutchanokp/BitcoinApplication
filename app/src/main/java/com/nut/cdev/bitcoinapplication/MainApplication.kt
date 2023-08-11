package com.nut.cdev.bitcoinapplication

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.nut.cdev.bitcoinapplication.di.apiModule
import com.nut.cdev.bitcoinapplication.di.appModule
import com.nut.cdev.bitcoinapplication.di.repoModule
import com.nut.cdev.bitcoinapplication.di.viewModelModule
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : MultiDexApplication() {

    lateinit var application: Application

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(appModule, repoModule, viewModelModule, apiModule))
        }

        setupRealm()
    }

    private fun setupRealm() {

        Realm.init(this)

        val configuration = RealmConfiguration.Builder()
            .name("bitcoin.realm")
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(0)
            .allowWritesOnUiThread(true)
            .allowQueriesOnUiThread(true)
            .build()

        Realm.setDefaultConfiguration(configuration)
    }
}
