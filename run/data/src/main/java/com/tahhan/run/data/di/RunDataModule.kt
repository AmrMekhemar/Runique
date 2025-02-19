package com.tahhan.run.data.di

import com.tahhan.core.domain.run.SyncRunScheduler
import com.tahhan.run.data.CreateRunWorker
import com.tahhan.run.data.DeleteRunWorker
import com.tahhan.run.data.FetchRunsWorker
import com.tahhan.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}