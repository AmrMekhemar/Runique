package com.tahhan.run.presentation.active_run.maps

import androidx.compose.ui.graphics.Color
import com.tahhan.core.domain.location.Location

data class PolylineUi(
    val location1: Location,
    val location2: Location,
    val color: Color
)
