package com.jtutzo.katanever.core.model.features

import com.jtutzo.katanever.core.model.Customer
import com.jtutzo.katanever.core.model.repositories.CustomerRepository
import cucumber.api.java.fr.Etantdonné
import io.cucumber.datatable.DataTable

class CustomerSteps constructor(private val customerRepository: CustomerRepository) {

    @Etantdonné("^des clients existent:$")
    fun desClientsExistent(dataTable: DataTable) {
        dataTable.asMaps().forEach {
            val customer = Customer(it["login"]!!, it["firstName"]!!, it["lastName"]!!)
            customerRepository.add(customer)
        }
    }
}
