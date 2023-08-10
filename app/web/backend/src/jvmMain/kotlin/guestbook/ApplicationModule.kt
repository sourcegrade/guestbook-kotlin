package guestbook

import guestbook.http.routeSession
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.resources.Resources
import io.ktor.server.routing.routing
import io.ktor.server.sessions.SessionStorageMemory
import io.ktor.server.sessions.Sessions
import io.ktor.server.sessions.cookie
import kotlinx.serialization.json.Json

@Suppress("unused") // Referenced in application.conf
fun Application.applicationModule() {
    println("Starting backend...")
    install(ContentNegotiation) {
        // TODO: protobuf
        json(
            Json {
                encodeDefaults = false
                ignoreUnknownKeys = true
            },
        )
    }
    // install type-safe routing
    install(Resources)

    install(Sessions) {
        cookie<String>(
            name = "user_session",
            storage = SessionStorageMemory(),
        ) {
            println("Test: ${sessionIdProvider()}")
        }
    }

    routing {
        routeSession()
    }

    println("Backend started!")
}
