package com.jtutzo.katanever.core.model.features

import com.jtutzo.katanever.core.model.gateways.AuthenticationGateway
import com.jtutzo.katanever.core.model.repositories.CustomerRepository
import cucumber.api.java.fr.Etantdonné
import org.assertj.core.api.Assertions

class UserSteps constructor(private val customerRepository: CustomerRepository, private val authenticationGateway: AuthenticationGateway) {
    @Etantdonné("^Je suis authentifié en tant que \"([^\"]*)\"$")
    @Throws(Throwable::class)
    fun jeSuisAuthentifieEnTantQue(login: String) { // Write code here that turns the phrase above into concrete actions
        val customer = customerRepository.find(login)
        customer?.let(authenticationGateway::authenticate)
        Assertions.assertThat(customer).isNotNull
    }
}
