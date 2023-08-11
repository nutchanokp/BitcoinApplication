package com.nut.cdev.bitcoinapplication.di

import com.nut.cdev.bitcoinapplication.BuildConfig
import com.nut.cdev.bitcoinapplication.data.ApiService
import com.nut.cdev.bitcoinapplication.data.AppService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


val apiModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
//    single { provideNetworkHelper(androidContext()) }

    single { createAppService(get()) }
    single { createOkHttpClient(get()) }
//    factory { createServiceApi() }
    factory { createConverterFactory() }
    factory { createRxJavaCallAdapter() }

}

//private fun provideNetworkHelper(context: Context) = NetworkHelper(context)
private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)


fun createAppService(retrofit: Retrofit): AppService {
    return retrofit.create(AppService::class.java)
}

//fun createServiceApi() = ServiceApi()

fun createOkHttpClient(
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    val httpClient = OkHttpClient.Builder()
//    val httpClient = unSafeOkHttpClient()
    httpClient.connectTimeout(60, TimeUnit.SECONDS)
    httpClient.readTimeout(60, TimeUnit.SECONDS)
    httpClient.addInterceptor { chain ->
        val original = chain.request()
        val request = original.newBuilder()
//            .addHeader("Content-Type", "application/json")
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