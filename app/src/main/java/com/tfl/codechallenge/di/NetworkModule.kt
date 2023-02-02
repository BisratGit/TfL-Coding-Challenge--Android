package com.tfl.codechallenge.di

import com.tfl.codechallenge.network.ApiClient.getRetrofitClient
import com.tfl.codechallenge.network.ApiClient.provideGson
import com.tfl.codechallenge.network.ApiClient.provideOKHttpClient
import org.koin.dsl.module

val networkModule = module {

    single { provideOKHttpClient() }
    single { provideGson() }
    single { getRetrofitClient(get(), get()) }

}