package com.jtutzo.katanever.core.model

import com.jtutzo.katanever.core.adapters.repositories.InMemoryCustomerRepository
import com.jtutzo.katanever.core.adapters.repositories.InMemoryBabySitterRepository
import cucumber.runtime.java.picocontainer.PicoFactory

class CustomPicoFactory: PicoFactory(){

    init {
        addClass(InMemoryCustomerRepository::class.java)
        addClass(InMemoryBabySitterRepository::class.java)
    }
}

