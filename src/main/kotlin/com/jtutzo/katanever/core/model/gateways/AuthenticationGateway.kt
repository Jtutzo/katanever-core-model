package com.jtutzo.katanever.core.model.gateways

import com.jtutzo.katanever.core.model.User

interface AuthenticationGateway {
    fun authenticate(user: User)
    fun current(): User?

}
