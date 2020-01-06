package com.jtutzo.katanever.core.model.features

import com.jtutzo.katanever.core.model.CucumberState
import com.jtutzo.katanever.core.model.repositories.BookingRepository
import cucumber.api.java.fr.Alors
import cucumber.api.java.fr.Et
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

    @Alors("La réservation n'est pas effective")
    fun laReservationNEstPasEffective() {
        val booking = bookingRepository.last()
        assertThat(booking).isNull()
        assertThat(cucumberState.bookingAttempt).isNull()
        assertThat(cucumberState.exception).isNotNull()
    }

    @Et("l'erreur {string} est levée lors de la réservation")
    fun lErreurEstLeveeLorsDeLaReservation(message: String?) {
        assertThat(cucumberState.exception).isNotNull()
        assertThat(cucumberState.exception).hasMessage(message)
    }
}
