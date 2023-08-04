package guestbook.domain

import org.sourcegrade.kontour.Creates
import org.sourcegrade.kontour.DomainEntity
import org.sourcegrade.kontour.UUID

data class Guestbook(
    override val id: UUID,
    val name: String,
    val entries: List<String>,
) : DomainEntity {
    data class CreateDto(
        val name: String,
    ) : Creates<Guestbook>
}
