package com.jtutzo.katanever.core.model.features

import com.jtutzo.katanever.core.model.BabySitter
import com.jtutzo.katanever.core.model.repositories.BabySitterRepository
import cucumber.api.PendingException
import cucumber.api.java.fr.Et
import cucumber.api.java.fr.Etantdonné
import io.cucumber.datatable.DataTable

class BabySitterSteps constructor(private val babySitterRepository: BabySitterRepository) {

    @Etantdonné("^des baby-sitters existent:$")
    fun desBabySittersExistent(dataTable: DataTable) {
        dataTable.asMaps().forEach {
            val babySitter = BabySitter(it["login"]!!, it["firstName"]!!, it["lastName"]!!)
            babySitterRepository.add(babySitter)
        }
    }

    @Et("^Le baby-sitter \"([^\"]*)\" est disponible le \"([^\"]*)\" pendant \"([^\"]*)\"$")
    @Throws(Throwable::class)
    fun leBabySitterEstDisponible(login: String, date: String, time: String) { // Write code here that turns the phrase above into concrete actions
        throw PendingException()
    }

    @Et("^Le baby-sitter \"([^\"]*)\" n\'est plus disponible le \"([^\"]*)\" pendant \"([^\"]*)\"$")
    @Throws(Throwable::class)
    fun leBabySitterNEstPlusDisponibleLePendant(login: String?, date: String?, hours: String?) { // Write code here that turns the phrase above into concrete actions
        throw PendingException()
    }
}
