package com.tfl.codechallenge.viewmodels

import androidx.lifecycle.ViewModel
import com.tfl.codechallenge.repository.TubeStatusRepo

class TubeStatusViewModel(private val tubeStatusRepo: TubeStatusRepo) : ViewModel() {

    fun getCurrentStatus() = tubeStatusRepo.currentTubeStatus

    fun retryGetCurrentStatus() {
        tubeStatusRepo.getDataFromApi()
    }
}


