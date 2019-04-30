package com.bc.todolistbackend.handler

import com.bc.todolistbackend.ListRepository
import com.bc.todolistbackend.ToDoList
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.noContent
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.util.*

@Component
class ListHandler(private val listRepository: ListRepository) {
    fun createList(req: ServerRequest): Mono<ServerResponse> {
        val toDoList = req.bodyToMono(ToDoList::class.java)
        return ok().body(listRepository.saveAll(toDoList))
    }

    fun getAllLists(req: ServerRequest): Mono<ServerResponse>
            = ok().body(listRepository.findAll())

    fun getList(req: ServerRequest): Mono<ServerResponse>
            = ok().body(listRepository.findById(req.pathVariable("id")))

    fun updateList(req: ServerRequest): Mono<ServerResponse> {
        val id = req.pathVariable("id")
        return this.listRepository.findById(id)
                .zipWith(req.bodyToMono(ToDoList::class.java))
                .map{
                    it.t1.copy(name = it.t2.name, list = it.t2.list )
                }
                .flatMap { this.listRepository.save(it) }
                .flatMap { noContent().build() }
    }
}