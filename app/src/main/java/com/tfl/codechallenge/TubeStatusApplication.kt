package com.tfl.codechallenge

import android.app.Application
import com.tfl.codechallenge.di.apiModule
import com.tfl.codechallenge.di.networkModule
import com.tfl.codechallenge.di.repositoryModule
import com.tfl.codechallenge.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TubeStatusApplication : Application() {

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@TubeStatusApplication)
            modules(apiModule, networkModule, repositoryModule, viewModelModule)
        }
    }
}