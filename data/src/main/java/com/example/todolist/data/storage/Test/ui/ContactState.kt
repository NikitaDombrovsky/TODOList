package com.example.todolist.data.storage.Test.ui

import com.example.roomkt.Contact
import com.example.roomkt.SortType

data class ContactState(
    val contacts: List<Contact> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val isAddingContact: Boolean = false,
    val sortType: SortType = SortType.FIRST_NAME

)
