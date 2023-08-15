package guestbook.http

import io.ktor.http.HttpStatusCode
import io.ktor.resources.Resource
import io.ktor.server.application.call
import io.ktor.server.resources.get
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.route
import org.sourcegrade.kontour.DomainEntity
import org.sourcegrade.kontour.Repository
import java.util.UUID

inline fun <reified E : DomainEntity> Route.registerRepositoryGet(
    name: String,
    repository: Repository<E>,
) {
    route("/api/$name") {
        get<ById> { (sid) ->
            val id = UUID.fromString(sid)
            val item = repository.getById(id)
            if (item == null) {
                call.respond(HttpStatusCode.NotFound, "Item with id $id not found in repository $name")
            } else {
                call.respond(HttpStatusCode.OK, item)
            }
        }
    }
}

@PublishedApi
@Resource("{id}")
internal data class ById(val id: String)
