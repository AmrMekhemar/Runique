package com.tahhan.auth.presentation.di

import com.tahhan.auth.presentation.login.LoginViewModel
import com.tahhan.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}