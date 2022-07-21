package com.charlsgod.bsidetest.presentation.data.database.contact

import androidx.room.*

@Dao
interface ContactDao {

    @Query("SELECT * FROM Contact")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM Contact WHERE id = :id")
    fun findById(id: Int): Contact

    @Query("SELECT * FROM Contact WHERE phone_number LIKE :phoneNumber LIMIT 1")
    fun findByPhoneNumber(phoneNumber: String): Contact

    @Query("SELECT COUNT(id) FROM Contact")
    fun contactCount(): Int

    @Delete
    fun delete(contact: Contact)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertContacts(contacts: List<Contact>)

    @Update
    fun updateContact(contact: Contact)
}