package com.tahhan.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}