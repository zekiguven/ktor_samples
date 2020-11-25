package com.zekiguven

import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.application.*
import io.ktor.mustache.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.mustache3() {
    install(Mustache) {
        mustacheFactory = DefaultMustacheFactory("templates/mustache")
    }

    routing {
        get("/") {
            val page = PageData(
                    "Bir web sitesi",
                    "Web sitesi açıklaması",
                    "www.zekiguven.com",
                    "http://www.zekiguven.com"

//                    listOf(
//                            Item("Item 1", "$19.99", listOf(Feature("New!"), Feature("Awesome!"))),
//                            Item("Item 2", "$29.99", listOf(Feature("Old."), Feature("Ugly.")))
//                    )
            )

            call.respond(MustacheContent("page.html", page ))
        }
    }
}

data class PageData(val title: String, val description: String, val domain: String, val url: String)
//data class HeadProps(names)
//data class PageContent(val header: List<String>, val items: List<Item>,val footer: List<String>)
//data class Feature(val description: String)
//data class Item(val name: String, val price: String, val features: List<Feature>)

