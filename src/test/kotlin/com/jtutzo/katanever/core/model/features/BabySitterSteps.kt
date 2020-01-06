package com.jtutzo.katanever.core.model.features

import com.jtutzo.katanever.core.model.*
import com.jtutzo.katanever.core.model.repositories.BabySitterRepository
import cucumber.api.java.fr.Alors
import cucumber.api.java.fr.Etantdonné
import io.cucumber.datatable.DataTable
import org.assertj.core.api.Assertions.*

class BabySitterSteps constructor(private val babySitterRepository: BabySitterRepository) {

    @Etantdonné("^des baby-sitters existent:$")
    fun desBabySittersExistent(dataTable: DataTable) {
        dataTable.asMaps().forEach {
            val babySitter = BabySitter(it["login"]!!, it["firstName"]!!, it["lastName"]!!)
            babySitterRepository.add(babySitter)
        }
    }

    @Etantdonné("^Le baby-sitter \"([^\"]*)\" est disponible le \"([^\"]*)\" à \"([^\"]*)\" pendant \"([^\"]*)\"$")
    @Throws(Throwable::class)
    fun leBabySitterEstDisponible(login: String, day: String, time: String, duration: String) {
        val babySitter = babySitterRepository.find(login)
        val timeSlot = TimeSlot(buildLocalDateTime(day, time), buildDuration(duration))
        babySitter?.add(timeSlot)
        assertThat(babySitter).isNotNull
    }

    @Alors("^Le baby-sitter \"([^\"]*)\" n\'est plus disponible le \"([^\"]*)\" à \"([^\"]*)\" pendant \"([^\"]*)\"$")
    @Throws(Throwable::class)
    fun leBabySitterNEstPlusDisponible(login: String, day: String, time: String, duration: String) {
        val timeSlot = TimeSlot(buildLocalDateTime(day, time), buildDuration(duration))
        val babySitter = babySitterRepository.find(login)
        assertThat(babySitter).isNotNull
        assertThat(babySitter!!.isAvailability(timeSlot)).isFalse()
    }
}
