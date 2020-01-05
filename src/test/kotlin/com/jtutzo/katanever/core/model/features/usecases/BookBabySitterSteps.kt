package com.jtutzo.katanever.core.model.features.usecases

import cucumber.api.PendingException
import cucumber.api.java.fr.Quand

class BookBabySitterSteps {
    @Quand("^Je reserve le baby-sitter \"([^\"]*)\" le \"([^\"]*)\" pendant \"([^\"]*)\"$")
    @Throws(Throwable::class)
    fun jeReserveLeBabySitterLePendant(login: String?, date: String?, hours: String?) { // Write code here that turns the phrase above into concrete actions
        throw PendingException()
    }
}
