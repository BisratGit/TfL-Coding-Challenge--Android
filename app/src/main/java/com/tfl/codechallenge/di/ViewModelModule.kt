package com.tfl.codechallenge.di

import com.tfl.codechallenge.viewmodels.TubeStatusViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { TubeStatusViewModel(get()) }
}