package com.nut.cdev.bitcoinapplication.di

import com.nut.cdev.bitcoinapplication.BuildConfig
import com.nut.cdev.bitcoinapplication.data.ApiService
import io.realm.Realm
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val apiModule = module {

    single { provideApiService(get()) }
    single { createOkHttpClient(get()) }
    factory { createConverterFactory() }
    factory { createRxJavaCallAdapter() }

}

private fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

fun createOkHttpClient(
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    val httpClient = OkHttpClient.Builder()
    httpClient.connectTimeout(60, TimeUnit.SECONDS)
    httpClient.readTimeout(60, TimeUnit.SECONDS)
    httpClient.addInterceptor { chain ->
        val original = chain.request()
        val request = original.newBuilder()
            .build()

        return@addInterceptor chain.proceed(request)
    }
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(httpClient.build())
        .addConverterFactory(gsonConverterFactory)
        .build()
}

fun createConverterFactory(): GsonConverterFactory {
    return GsonConverterFactory.create()
}

fun createRxJavaCallAdapter(): RxJava2CallAdapterFactory {
    return RxJava2CallAdapterFactory.create()
}