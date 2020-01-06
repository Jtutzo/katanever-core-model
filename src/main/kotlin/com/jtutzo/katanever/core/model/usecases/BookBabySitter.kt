package com.jtutzo.katanever.core.model.usecases

import com.jtutzo.katanever.core.model.BabySitter
import com.jtutzo.katanever.core.model.repositories.BookingRepository
import com.jtutzo.katanever.core.model.Booking
import com.jtutzo.katanever.core.model.Customer
import com.jtutzo.katanever.core.model.TimeSlot
import com.jtutzo.katanever.core.model.gateways.AuthenticationGateway
import com.jtutzo.katanever.core.model.repositories.BabySitterRepository
import com.jtutzo.katanever.core.model.repositories.CustomerRepository
import java.time.Duration
import java.time.LocalDateTime

class BookBabySitter(private val authenticationGateway: AuthenticationGateway,
                     private val customerRepository: CustomerRepository,
                     private val babySitterRepository: BabySitterRepository,
                     private val bookingRepository: BookingRepository) {

    fun handle(babySitterLogin: String, date: LocalDateTime, duration: Duration) {
        val customer = loadCustomer()
        val babySitter = babySitterRepository.find(babySitterLogin)
        val timeSlot = TimeSlot(date, duration)
        book(babySitter!!, timeSlot)
        applyBooking(customer!!, babySitter, timeSlot)
    }

    private fun loadCustomer(): Customer? {
        val user = authenticationGateway.current()
        return customerRepository.find(user!!.login)
    }

    private fun book(babySitter: BabySitter, timeSlot: TimeSlot) {
        babySitter.book(timeSlot)
        babySitterRepository.save(babySitter)
    }

    private fun applyBooking(customer: Customer, babySitter: BabySitter, timeSlot: TimeSlot) {
        val booking = Booking(customer, babySitter, timeSlot)
        bookingRepository.add(booking)
    }


}
