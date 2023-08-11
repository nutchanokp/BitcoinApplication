package com.nut.cdev.bitcoinapplication

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

class DataModule {
    companion object {
        @JvmStatic
        val LOCALE_TH = Locale("th", "TH")

        @JvmStatic
        @Volatile
        private var applicationContext: Context? = null

        @JvmStatic
        private var mBaseUrl = ""

        @JvmStatic
        private var url = ""

        @JvmStatic
        fun getModuleContext(): Context {
            checkNotNull(applicationContext)
            return applicationContext!!
        }   }
}

