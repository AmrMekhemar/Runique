package com.tahhan.auth.data.di

import com.tahhan.auth.data.AuthRepositoryImpl
import com.tahhan.auth.data.EmailPatternValidator
import com.tahhan.auth.domain.AuthRepository
import com.tahhan.auth.domain.PatternValidator
import com.tahhan.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator>{
        EmailPatternValidator()
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}