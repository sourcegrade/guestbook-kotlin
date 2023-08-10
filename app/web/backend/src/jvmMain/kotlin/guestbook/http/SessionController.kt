package guestbook.http

import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.sessions.sessionId

fun Route.routeSession() {
    get("/api/v1/session") {
        println("Session ID: ${call.sessionId}")
    }
}
