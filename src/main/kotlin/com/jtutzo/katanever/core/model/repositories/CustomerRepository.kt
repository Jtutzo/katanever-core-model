package com.jtutzo.katanever.core.model.repositories

import com.jtutzo.katanever.core.model.Customer

interface CustomerRepository {
    fun add(customer: Customer)
}
