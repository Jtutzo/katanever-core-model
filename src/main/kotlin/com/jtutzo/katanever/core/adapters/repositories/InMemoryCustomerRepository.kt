package com.jtutzo.katanever.core.adapters.repositories

import com.jtutzo.katanever.core.model.Customer
import com.jtutzo.katanever.core.model.repositories.CustomerRepository

class InMemoryCustomerRepository: CustomerRepository {

    private val customers = mutableSetOf<Customer>()

    override fun add(customer: Customer) {
        customers.add(customer)
    }

    override fun find(login: String): Customer? = customers.findLast { it.login == login }

}
