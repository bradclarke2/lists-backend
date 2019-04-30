package com.bc.todolistbackend

import com.bc.todolistbackend.api.ApiRoutes
import com.bc.todolistbackend.handler.ListHandler
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

@RunWith(SpringRunner::class)
@SpringBootTest
class PutRequestShould {
    final var mock = mock(ListRepository::class.java)
    var client = WebTestClient.bindToRouterFunction(
            ApiRoutes().router(listHandler = ListHandler(mock))
    ).build()

    @Test
    fun updateListItem() {
//        val toDoList: Mono<ToDoList> = Mono.just()
//        Mockito.`when`(mock.findById("1234")).thenReturn(toDoList)
//        client.put()
//                .uri("/lists/1234")
//                .body()
//                .exchange()

    }
}