package com.charlsgod.bsidetest.domain

data class Contact(
    val id: Int,
    val name: String,
    val lastNames: String,
    val phoneNumber: String,
    val address: String,
    val email: String,
    val favorite: Boolean
)