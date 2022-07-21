package com.charlsgod.bsidetest.presentation.data.database.contact

import com.charlsgod.bsidetest.data.source.LocalContactDataSource
import com.charlsgod.bsidetest.domain.Contact
import com.charlsgod.bsidetest.presentation.data.toDbContact
import com.charlsgod.bsidetest.presentation.data.toDomainContact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactMovieDataSource(db: ContactDatabase) : LocalContactDataSource {

    private val contactDao = db.contactDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { contactDao.contactCount() <= 0 }

    override suspend fun saveContacts(contacts: List<Contact>) {
        withContext(Dispatchers.IO) { contactDao.insertContacts(contacts.map { it.toDbContact() }) }
    }

    override suspend fun findById(id: Int): Contact = withContext(Dispatchers.IO) {
        contactDao.findById(id).toDomainContact()
    }

    override suspend fun update(contact: Contact) {
        withContext(Dispatchers.IO) { contactDao.updateContact(contact.toDbContact()) }
    }
}