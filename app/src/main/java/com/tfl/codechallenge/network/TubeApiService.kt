package com.tfl.codechallenge.network

import com.tfl.codechallenge.datamodels.CurrentStatus
import retrofit2.Response
import retrofit2.http.GET

interface TubeApiService {
    @GET("Line/Mode/Tube/Status")
    suspend fun getAllTubeStatus(): Response<List<CurrentStatus>>
}