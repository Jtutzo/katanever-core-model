package com.jtutzo.katanever.core.adapters.repositories

import com.jtutzo.katanever.core.model.BabySitter
import com.jtutzo.katanever.core.model.repositories.BabySitterRepository

class InMemoryBabySitterRepository : BabySitterRepository {

    private val babySitters = mutableSetOf<BabySitter>()

    override fun add(babySitter: BabySitter) {
        babySitters.add(babySitter)
    }

    override fun find(login: String): BabySitter? = babySitters.findLast { it.login == login }

    override fun save(babySitter: BabySitter) {
        babySitters.removeIf { it.login == babySitter.login }
        add(babySitter)
    }

}
