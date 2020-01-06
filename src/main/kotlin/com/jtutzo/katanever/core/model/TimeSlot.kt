package com.jtutzo.katanever.core.model

import java.time.Duration
import java.time.LocalDateTime

typealias TimeSlots = Iterable<TimeSlot>

data class TimeSlot(val startDate: LocalDateTime, val duration: Duration) {
    companion object {
        fun between(startDateInclude: LocalDateTime, endDateExclude: LocalDateTime): TimeSlot =
                TimeSlot(startDateInclude, Duration.between(startDateInclude, endDateExclude))
    }
}

fun TimeSlot.endDate(): LocalDateTime = startDate.plus(duration)

fun TimeSlots.merge(timeSlot: TimeSlot) = this
        .plus(timeSlot)
        .groupBy { it.exclude(timeSlot) }
        .flatMap {
            if (!it.key) setOf(it.value
                    .reduce { acc, timeSlot -> acc.merge(timeSlot) })
            else it.value
        }
        .toSet()

fun TimeSlots.remove(timeSlot: TimeSlot) = this
        .filter { it.include(timeSlot) }
        .flatMap { it.remove(timeSlot) }
        .toSet()

private fun TimeSlot.merge(timeSlot: TimeSlot): TimeSlot = when {
    isBefore(timeSlot) -> mergeBefore(timeSlot)
    isAfter(timeSlot) -> mergeAfter(timeSlot)
    include(timeSlot) -> copy()
    else -> timeSlot.copy()
}

private fun TimeSlot.remove(timeSlot: TimeSlot): TimeSlots = when {
    timeSlot.isSame(this) -> emptySet()
    timeSlot.isBefore(this) -> removeAtTheBeginning(timeSlot)
    timeSlot.isAfter(this) -> removeAtTheEnd(timeSlot)
    include(timeSlot) -> removeInCenter(timeSlot)
    else -> setOf(copy())
}

fun TimeSlot.isSame(timeSlot: TimeSlot) =
        startDate.isEqual(timeSlot.startDate) && endDate().isEqual(timeSlot.endDate())

fun TimeSlot.isBefore(timeSlot: TimeSlot) =
        startDate <= timeSlot.startDate && endDate() <= timeSlot.endDate()

fun TimeSlot.isAfter(timeSlot: TimeSlot) =
        startDate >= timeSlot.startDate && endDate() >= timeSlot.endDate()

fun TimeSlot.include(timeSlot: TimeSlot) =
        startDate <= timeSlot.startDate && endDate() >= timeSlot.endDate()

fun TimeSlot.exclude(timeSlot: TimeSlot) =
        startDate > timeSlot.endDate() && endDate() < timeSlot.startDate

private fun TimeSlot.removeAtTheBeginning(timeSlot: TimeSlot) =
        setOf(TimeSlot.between(timeSlot.endDate(), endDate()))

private fun TimeSlot.removeAtTheEnd(timeSlot: TimeSlot) =
        setOf(TimeSlot.between(startDate, timeSlot.startDate))

private fun TimeSlot.removeInCenter(timeSlot: TimeSlot) =
        setOf(TimeSlot.between(startDate, timeSlot.startDate),
                TimeSlot.between(timeSlot.endDate(), endDate()))

private fun TimeSlot.mergeBefore(timeSlot: TimeSlot) = TimeSlot.between(startDate, timeSlot.endDate())

private fun TimeSlot.mergeAfter(timeSlot: TimeSlot) = TimeSlot.between(timeSlot.startDate, endDate())
