package com.bc.todolistbackend.repository

import com.bc.todolistbackend.domain.ToDoList
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface ListRepository : ReactiveMongoRepository<ToDoList, String> {
	override fun findAll() : Flux<ToDoList>
	override fun findById(id: String): Mono<ToDoList>
}