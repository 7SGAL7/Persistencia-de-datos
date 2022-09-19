package com.textview.persistenciadedatos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = Contact.Table_name)
data class Contact(

    @NotNull
    @PrimaryKey//(autoGenerate = true)
    @ColumnInfo(name = "id") val contactId: Int,

    @ColumnInfo(name = "first_name") @NotNull val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String? = null,
    @ColumnInfo(name = "gender") @NotNull val gender: String

) {

    companion object {
        const val Table_name = "contact"
    }

}
