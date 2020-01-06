package com.jtutzo.katanever.core.model

data class Customer(override val login: String, val firstName: String, val lastName: String): User
