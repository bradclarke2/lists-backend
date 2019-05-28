package com.bc.todolistbackend.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class ToDoList(
        @Id var id: String? = null,
        val name: String,
        val list: ArrayList<ListItem>
)