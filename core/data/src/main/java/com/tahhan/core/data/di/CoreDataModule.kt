package com.tahhan.core.data.di

import com.tahhan.core.data.auth.EncryptedSessionStorage
import com.tahhan.core.data.networking.HttpClientFactory
import com.tahhan.core.data.run.OfflineFirstRunRepository
import com.tahhan.core.domain.SessionStorage
import com.tahhan.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}