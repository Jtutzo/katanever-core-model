package com.jtutzo.katanever.core.model.repositories

import com.jtutzo.katanever.core.model.Booking

interface BookingRepository {
    fun add(booking: Booking)
    fun last(): Booking?
}