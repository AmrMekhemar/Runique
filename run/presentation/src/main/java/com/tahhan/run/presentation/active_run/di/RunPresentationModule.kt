package com.tahhan.run.presentation.active_run.di

import com.tahhan.run.domain.RunningTracker
import com.tahhan.run.presentation.active_run.ActiveRunViewModel
import com.tahhan.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}