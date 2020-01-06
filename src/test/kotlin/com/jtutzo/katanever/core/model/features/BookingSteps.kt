package com.jtutzo.katanever.core.model.features

import com.jtutzo.katanever.core.model.CucumberState
import com.jtutzo.katanever.core.model.repositories.BookingRepository
import cucumber.api.java.fr.Alors
import org.assertj.core.api.Assertions.assertThat

class BookingSteps constructor(private val cucumberState: CucumberState, private val bookingRepository: BookingRepository) {
    @Alors("^La réservation est effective$")
    fun laReservationEstEffective() {
        val booking = bookingRepository.last()
        assertThat(cucumberState.exception).isNull()
        assertThat(booking).isNotNull
        assertThat(cucumberState.bookingAttempt).isNotNull
        assertThat(booking).isEqualTo(cucumberState.bookingAttempt)
    }
}
