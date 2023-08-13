package com.nut.cdev.bitcoinapplication.di

import com.nut.cdev.bitcoinapplication.data.repository.MainRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        MainRepository(get())
    }
}