package com.tfl.codechallenge.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tfl.codechallenge.R
import com.tfl.codechallenge.databinding.ActivityTubeStatusBinding
import com.tfl.codechallenge.datamodels.CurrentStatus
import com.tfl.codechallenge.util.Constants
import com.tfl.codechallenge.util.Status.*
import com.tfl.codechallenge.viewmodels.TubeStatusViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TubeStatusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTubeStatusBinding
    private val tubeStatusViewModel: TubeStatusViewModel by viewModel()
    private val tubeStatusAdapter: TubeStatusAdapter
            by lazy { TubeStatusAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tube_status)
        binding.executePendingBindings()
        observeCurrentTubeStatus()
        binding.btnRetry.setOnClickListener {
            binding.messageContainer.visibility = View.GONE
            tubeStatusViewModel.retryGetCurrentStatus()
        }
    }

    private fun displayCurrentTubeStatus(tubeStatusList: List<CurrentStatus>) {
        binding.currentStatusRv.adapter = tubeStatusAdapter
        tubeStatusAdapter.submitList(tubeStatusList)
    }

    private fun observeCurrentTubeStatus() {
        tubeStatusViewModel.getCurrentStatus().observe(this) { result ->
            when (result?.status) {
                LOADING -> {
                    binding.currentStatusRv.visibility = View.GONE
                    binding.progressCircular.visibility = View.VISIBLE
                }
                SUCCESS -> result.data?.let { currentStatus ->
                    binding.progressCircular.visibility = View.GONE
                    binding.currentStatusRv.visibility = View.VISIBLE
                    binding.messageContainer.visibility = View.GONE
                    displayCurrentTubeStatus(currentStatus)
                }
                ERROR -> displayErrorMessage(result.message, result.code)
                else -> displayErrorMessage(null, Constants.UNKNOWN_ERROR)
            }
        }
    }


    private fun displayErrorMessage(message: String?, errorCode: Int?) {
        binding.currentStatusRv.visibility = View.GONE
        binding.messageContainer.visibility = View.VISIBLE
        binding.progressCircular.visibility = View.GONE
        binding.errorMessage.apply {
            when (errorCode) {
                Constants.NO_NETWORK_ERROR -> {
                    text = "$message\n ${resources.getString(R.string.network_error)}"
                }
                Constants.UNKNOWN_ERROR -> {
                    text =
                        "$message\n ${resources.getString(R.string.something_went_wrong_message)}"
                }
                in Constants.NET_RANGE_400_500 -> {
                    text = "$message\n ${resources.getString(R.string.api_network_error)}"
                }
            }
        }

    }

}