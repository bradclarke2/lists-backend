package com.bc.todolistbackend.handler

import com.bc.todolistbackend.domain.ToDoList
import com.bc.todolistbackend.repository.ListRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.noContent
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class ListHandler(val listRepository: ListRepository) {
    val logger: Logger = LoggerFactory.getLogger(ListHandler::class.java)

    fun createList(req: ServerRequest): Mono<ServerResponse> {
        val toDoList = req.bodyToMono(ToDoList::class.java)
        logger.info("saving")
        return ok().body(listRepository.saveAll(toDoList))
    }

    fun getAllLists(req: ServerRequest): Mono<ServerResponse>
            = ok().header("Access-Control-Allow-Origin", "*").body(listRepository.findAll())

    fun getList(req: ServerRequest): Mono<ServerResponse>
            = ok().body(listRepository.findById(req.pathVariable("id")))

    fun updateList(req: ServerRequest): Mono<ServerResponse> {
        val id = req.pathVariable("id")

        return listRepository.findById(id)
                .zipWith(req.bodyToMono(ToDoList::class.java))
                .map {
                    it.t1.copy(name = it.t2.name, list = it.t2.list)
                }
                .flatMap { listRepository.save(it) }
                .flatMap { noContent().build() }
    }
}