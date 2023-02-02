package com.tfl.codechallenge.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.tfl.codechallenge.datamodels.CurrentStatus
import com.tfl.codechallenge.network.TubeApiService
import com.tfl.codechallenge.util.Constants
import com.tfl.codechallenge.util.ResultWrapper
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

@RunWith(JUnit4::class)
class TubeStatusRepoTest {

    private lateinit var tubeStatusRepo: TubeStatusRepo
    private lateinit var tubeApiService: TubeApiService

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        tubeApiService = mock(TubeApiService::class.java)
        tubeStatusRepo = TubeStatusRepo(tubeApiService)
    }


    @Test
    fun when_tubeStatusRepo_isInitialized_then_getDataFromApiCalled() {
        val fakeTubeStatus = MutableLiveData<ResultWrapper<List<CurrentStatus>>>()
        fakeTubeStatus.value = ResultWrapper.loading(null)

        //assert
        assertEquals(tubeStatusRepo.currentTubeStatus.value, fakeTubeStatus.value)
    }

    @Test
    fun when_submitErrorResult_then_currentTubeStatus_value_isError() {
        //when
        tubeStatusRepo.submitErrorResult(Throwable())
        //assert
        assertEquals(
            ResultWrapper.error(null, Constants.UNKNOWN_ERROR, null),
            tubeStatusRepo.currentTubeStatus.value
        )
    }

}