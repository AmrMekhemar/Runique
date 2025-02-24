package com.tahhan.auth.presentation.login

import com.tahhan.core.presentation.ui.UiText

sealed interface LoginEvent {
    data object LoginSuccess : LoginEvent
    data class Error(val error: UiText) : LoginEvent
}