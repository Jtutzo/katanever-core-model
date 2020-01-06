package com.jtutzo.katanever.core.model.features.usecases

import com.jtutzo.katanever.core.model.*
import com.jtutzo.katanever.core.model.gateways.AuthenticationGateway
import com.jtutzo.katanever.core.model.repositories.BabySitterRepository
import com.jtutzo.katanever.core.model.repositories.BookingRepository
import com.jtutzo.katanever.core.model.repositories.CustomerRepository
import com.jtutzo.katanever.core.model.usecases.BookBabySitter
import cucumber.api.java.fr.Et
import cucumber.api.java.fr.Quand

class BookBabySitterSteps constructor(private val cucumberState: CucumberState,
                                      private val authenticationGateway: AuthenticationGateway,
                                      private val babySitterRepository: BabySitterRepository,
                                      private val customerRepository: CustomerRepository,
                                      bookingRepository: BookingRepository) {

    private val bookBabySitter = BookBabySitter(authenticationGateway, customerRepository, babySitterRepository, bookingRepository)

    @Quand("^Je reserve le baby-sitter \"([^\"]*)\" le \"([^\"]*)\" pendant \"([^\"]*)\"$")
    @Throws(Throwable::class)
    fun jeReserveLeBabySitter(login: String, dateTime: String, duration: String) {
        try {
            bookBabySitter.handle(login, buildLocalDateTime(dateTime), buildDuration(duration))
            this.bookingAttempt(login, dateTime, duration)
        } catch (e: Exception) {
            cucumberState.exception = e
        }
    }

    private fun bookingAttempt(babySitterLogin: String, dateTime: String, duration: String) {
        val user = authenticationGateway.current()
        val customer = customerRepository.find(user!!.login)
        val babySitter = babySitterRepository.find(babySitterLogin)
        val timeSlot = TimeSlot(buildLocalDateTime(dateTime), buildDuration(duration))
        cucumberState.bookingAttempt = Booking(customer!!, babySitter!!, timeSlot)
    }
}
