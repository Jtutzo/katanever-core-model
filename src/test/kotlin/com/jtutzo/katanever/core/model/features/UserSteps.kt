package com.jtutzo.katanever.core.model.features

import cucumber.api.PendingException
import cucumber.api.java.fr.Etantdonné

class UserSteps {
    @Etantdonné("^Je suis authentifié en tant que \"([^\"]*)\"$")
    @Throws(Throwable::class)
    fun jeSuisAuthentifieEnTantQue(login: String) { // Write code here that turns the phrase above into concrete actions
        throw PendingException()
    }
}
