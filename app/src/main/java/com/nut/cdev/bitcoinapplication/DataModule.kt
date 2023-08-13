package com.nut.cdev.bitcoinapplication

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

class DataModule {
    companion object {

        @JvmStatic
        @Volatile
        private var applicationContext: Context? = null

        @JvmStatic
        fun getModuleContext(): Context {
            checkNotNull(applicationContext)
            return applicationContext!!
        }   }
}

