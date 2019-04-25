package com.bc.todolistbackend

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class ToDoList {
    @Id
    var id: String? = null
    val list: String

    constructor(list: String) {
        this.list = list
    }

}