package com.tfl.codechallenge.di

import com.tfl.codechallenge.network.TubeApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    fun tubeApiService(retrofit: Retrofit): TubeApiService {
        return retrofit.create(TubeApiService::class.java)
    }

    single { tubeApiService(get()) }
}