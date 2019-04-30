package com.bc.todolistbackend.api

import com.bc.todolistbackend.handler.ListHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class ApiRoutes {
    @Bean
    fun router(listHandler: ListHandler) = router {
        GET("/lists", listHandler::getAllLists)
        POST("/lists", listHandler::createList)
        GET("/lists/{id}", listHandler::getList)
        PUT("/lists/{id}", listHandler::updateList)
    }
}