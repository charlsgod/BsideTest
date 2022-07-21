package com.charlsgod.bsidetest.presentation.data.database.contact

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val lastNames: String,
    val phoneNumber: String,
    val address: String,
    val email: String,
    val favorite: Boolean
)