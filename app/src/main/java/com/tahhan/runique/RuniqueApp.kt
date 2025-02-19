package com.tahhan.runique

import android.app.Application
import com.tahhan.auth.data.di.authDataModule
import com.tahhan.auth.presentation.di.authViewModelModule
import com.tahhan.core.data.di.coreDataModule
import com.tahhan.core.database.di.databaseModule
import com.tahhan.run.data.di.runDataModule
import com.tahhan.run.location.di.locationModule
import com.tahhan.run.network.di.networkModule
import com.tahhan.run.presentation.active_run.di.runPresentationModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }
}