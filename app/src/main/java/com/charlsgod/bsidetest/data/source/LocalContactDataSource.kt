package com.charlsgod.bsidetest.data.source

import com.charlsgod.bsidetest.domain.Contact

interface LocalContactDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveContacts(contacts: List<Contact>)
    suspend fun findById(id: Int): Contact
    suspend fun update(contact: Contact)
}