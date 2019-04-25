package com.bc.todolistbackend

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface ListRepository : ReactiveMongoRepository<ToDoList, String> {
	override fun findAll() : Flux<ToDoList>
}