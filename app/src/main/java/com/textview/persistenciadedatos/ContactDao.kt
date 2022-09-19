package com.textview.persistenciadedatos

import androidx.room.*

@Dao
interface ContactDao {
    @Insert
    suspend fun insert(contact: Contact)

    @Query("SELECT * FROM " + Contact.Table_name ) //" ORDER BY last_name, first_name"
    fun getContacts(): List<Contact>


    @Delete
    fun deleteContact(contact: Contact)


     @Update
     fun update(contact: Contact)


}