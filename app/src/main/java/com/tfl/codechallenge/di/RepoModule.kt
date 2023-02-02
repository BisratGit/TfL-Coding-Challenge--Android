package com.tfl.codechallenge.di

import com.tfl.codechallenge.network.TubeApiService
import com.tfl.codechallenge.repository.TubeStatusRepo
import org.koin.dsl.module

val repositoryModule = module {

    fun provideTubeStatusRepository(tubeApiService: TubeApiService): TubeStatusRepo {
        return TubeStatusRepo(tubeApiService)
    }

    single { provideTubeStatusRepository(get()) }
}