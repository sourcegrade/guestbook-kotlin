package guestbook.http

import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import org.sourcegrade.kontour.DomainEntity
import org.sourcegrade.kontour.Repository

fun <E : DomainEntity> Route.routeGetAll(
    repository: Repository<E, *>,
) {
    get {
        call.respond(repository)
    }
}
