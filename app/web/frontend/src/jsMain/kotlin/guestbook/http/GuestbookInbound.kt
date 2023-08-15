package guestbook.http

import io.ktor.client.HttpClient
import org.sourcegrade.kontour.Creates
import org.sourcegrade.kontour.DomainEntity
import org.sourcegrade.kontour.Repository
import org.sourcegrade.kontour.UUID

class ClientRepository<E : DomainEntity, C : Creates<E>>(
    val httpClient: HttpClient,
) : Repository<E, C> {
    override suspend fun countAll(): Long {

    }

    override suspend fun deleteById(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun exists(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: UUID): E? {

    }

    override suspend fun create(item: C): E {
        TODO("Not yet implemented")
    }
}
