package com.tahhan.auth.domain

import com.tahhan.core.domain.util.DataError
import com.tahhan.core.domain.util.EmptyResult

interface AuthRepository {

    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}