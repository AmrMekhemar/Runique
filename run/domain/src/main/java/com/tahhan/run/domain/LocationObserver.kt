package com.tahhan.run.domain

import com.tahhan.core.domain.location.LocationWithAltitude
import kotlinx.coroutines.flow.Flow

interface LocationObserver {
    fun observeLocation(interval : Long) : Flow<LocationWithAltitude>
}