package com.jtutzo.katanever.core.adapters.repositories

import com.jtutzo.katanever.core.model.Booking
import com.jtutzo.katanever.core.model.repositories.BookingRepository

class InMemoryBookingRepository : BookingRepository {

    private val bookings = mutableSetOf<Booking>()

    override fun add(booking: Booking) {
        bookings.add(booking)
    }

    override fun last(): Booking? = bookings.lastOrNull()
}
