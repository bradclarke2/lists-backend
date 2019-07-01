package com.bc.todolistbackend.domain

data class ListItem(
        val content: String? = "",
        val coordinates: Coordinates? = null,
        val complete: Boolean = false
)
