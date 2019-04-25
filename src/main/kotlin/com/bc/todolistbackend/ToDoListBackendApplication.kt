package com.bc.todolistbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToDoListBackendApplication

fun main(args: Array<String>) {
	runApplication<ToDoListBackendApplication>(*args)
}

