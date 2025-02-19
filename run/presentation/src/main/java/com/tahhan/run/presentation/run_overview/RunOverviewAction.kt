package com.tahhan.run.presentation.run_overview

import com.tahhan.run.presentation.run_overview.model.RunUi

interface RunOverviewAction {
    data object OnStartClick: RunOverviewAction
    data object OnLogoutClick: RunOverviewAction
    data object OnAnalyticsClick: RunOverviewAction
    data class DeleteRun(val runUi: RunUi): RunOverviewAction
}