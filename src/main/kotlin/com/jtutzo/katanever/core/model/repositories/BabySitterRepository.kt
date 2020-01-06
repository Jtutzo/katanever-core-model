package com.jtutzo.katanever.core.model.repositories

import com.jtutzo.katanever.core.model.BabySitter

interface BabySitterRepository {

    fun add(babySitter: BabySitter)
    fun find(login: String): BabySitter?
    fun save(babySitter: BabySitter)

}
