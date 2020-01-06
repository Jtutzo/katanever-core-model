package com.jtutzo.katanever.core.model

import java.lang.RuntimeException

data class BabySitter(override val login: String, val firstName: String, val lastName: String) : User {

    private var availabilities: TimeSlots = emptySet()

    fun add(timeSlot: TimeSlot) {
        this.availabilities = availabilities.merge(timeSlot)
    }

    fun book(timeSlot: TimeSlot) {
        if (!isAvailability(timeSlot))
            throw RuntimeException("La baby-sitter n'est pas disponible pour cette période")
        availabilities = availabilities.remove(timeSlot)
    }

    fun isAvailability(timeSlot: TimeSlot) = availabilities.any { it.include(timeSlot) }
}
