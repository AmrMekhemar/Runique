package com.tahhan.run.presentation.run_overview.mapper

import com.tahhan.core.domain.run.Run
import com.tahhan.run.presentation.run_overview.model.RunUi
import com.tahhan.core.presentation.ui.formatted
import com.tahhan.core.presentation.ui.toFormattedKm
import com.tahhan.core.presentation.ui.toFormattedKmh
import com.tahhan.core.presentation.ui.toFormattedMeters
import com.tahhan.core.presentation.ui.toFormattedPace
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Run.toRunUi(): RunUi {
    val dateTimeInLocalTime = dateTimeUtc
        .withZoneSameInstant(ZoneId.systemDefault())
    val formattedDateTime = DateTimeFormatter
        .ofPattern("MMM dd, yyyy - hh:mma")
        .format(dateTimeInLocalTime)

    val distanceKm = distanceMeters / 1000.0

    return RunUi(
        id = id!!,
        duration = duration.formatted(),
        dateTime = formattedDateTime,
        distance = distanceKm.toFormattedKm(),
        avgSpeed = avgSpeedKmh.toFormattedKmh(),
        maxSpeed = maxSpeedKmh.toFormattedKmh(),
        pace = duration.toFormattedPace(distanceKm),
        totalElevation = totalElevationMeters.toFormattedMeters(),
        mapPictureUrl = mapPictureUrl
    )
}