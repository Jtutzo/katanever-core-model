package com.jtutzo.katanever.core.adapters.gateways

import com.jtutzo.katanever.core.model.User
import com.jtutzo.katanever.core.model.gateways.AuthenticationGateway

class InMemoryAuthenticationGateway : AuthenticationGateway {

    private var currentUser: User? = null

    override fun authenticate(user: User) {
        currentUser = user
    }

    override fun current(): User? = currentUser
}
