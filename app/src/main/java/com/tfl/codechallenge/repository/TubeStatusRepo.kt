package com.tfl.codechallenge.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tfl.codechallenge.datamodels.CurrentStatus
import com.tfl.codechallenge.network.TubeApiService
import com.tfl.codechallenge.util.Constants
import com.tfl.codechallenge.util.ResultWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.net.UnknownHostException


class TubeStatusRepo(private val tubeApiService: TubeApiService) {


    private val _currentTubeStatus = MutableLiveData<ResultWrapper<List<CurrentStatus>>>()
    val currentTubeStatus: LiveData<ResultWrapper<List<CurrentStatus>>>
        get() = _currentTubeStatus


    init {
        getDataFromApi()
    }

    fun getDataFromApi() {
        _currentTubeStatus.postValue(ResultWrapper.loading(null))
        CoroutineScope(Dispatchers.IO).launch {
            val response = flow { emit(tubeApiService.getAllTubeStatus()) }
            response.catch { error ->
                submitErrorResult(error)
            }.collect { result ->
                submitSuccessResult(result)
            }
        }
    }

    fun submitErrorResult(error: Throwable) {
        when (error) {
            is UnknownHostException -> _currentTubeStatus.postValue(
                ResultWrapper.error(error.message, Constants.NO_NETWORK_ERROR, null)
            )
            else -> _currentTubeStatus.postValue(
                ResultWrapper.error(error.message, Constants.UNKNOWN_ERROR, null)
            )
        }
    }

    private fun submitSuccessResult(result: Response<List<CurrentStatus>>) {
        if (result.isSuccessful) {
            _currentTubeStatus.postValue(ResultWrapper.success(result.body()))
        } else if (result.code() in Constants.NET_RANGE_400_500) {
            result.errorBody()?.close()
            _currentTubeStatus.postValue(
                ResultWrapper.error(
                    result.message(),
                    result.code(), null
                )
            )
        } else {
            result.errorBody()?.close()
            _currentTubeStatus.postValue(
                ResultWrapper.error(
                    result.message(),
                    Constants.UNKNOWN_ERROR,
                    null
                )
            )
        }
    }
}

