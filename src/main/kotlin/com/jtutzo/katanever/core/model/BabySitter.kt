package com.jtutzo.katanever.core.model

data class BabySitter(override val login: String, val firstName: String, val lastName: String) : User {

    private var availabilities: TimeSlots = emptySet()

    fun add(timeSlot: TimeSlot) {
        this.availabilities = availabilities.merge(timeSlot)
    }

    fun book(timeSlot: TimeSlot) {
        availabilities = availabilities.remove(timeSlot)
    }

    fun isAvailability(timeSlot: TimeSlot) = availabilities.any { it.include(timeSlot) }
}
