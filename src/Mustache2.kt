package com.zekiguven

import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.application.*
import io.ktor.mustache.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.mustache2() {
    install(Mustache) {
        mustacheFactory = DefaultMustacheFactory("templates/mustache")
    }

    routing {
        get("/") {
            val page = Page(
                    listOf("aaa@test.com", "bbb@test.com"),
                    listOf(
                            Item("Item 1", "$19.99", listOf(Feature("New!"), Feature("Awesome!"))),
                            Item("Item 2", "$29.99", listOf(Feature("Old."), Feature("Ugly.")))
                    )
            )

            call.respond(MustacheContent("hello.html", page ))
        }
    }
}


data class Page(val emails: List<String>, val items: List<Item>)
data class Feature(val description: String)
data class Item(val name: String, val price: String, val features: List<Feature>)

