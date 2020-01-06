package com.jtutzo.katanever.core.model

import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val FORMAT_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm")

fun buildLocalDateTime(day: String, time: String): LocalDateTime = LocalDateTime.parse("$day $time", FORMAT_DATE)
fun buildLocalDateTime(dateTime: String): LocalDateTime = LocalDateTime.parse(dateTime, FORMAT_DATE)

fun buildDuration(duration: String): Duration {
    val durationSeparated = duration.split(":")
    return Duration.parse("PT${durationSeparated[0]}H${durationSeparated[1]}M")
}
