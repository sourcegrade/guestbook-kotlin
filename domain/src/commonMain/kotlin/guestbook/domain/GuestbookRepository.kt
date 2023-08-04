package guestbook.domain

import org.sourcegrade.kontour.Repository

interface GuestbookRepository : Repository<Guestbook, Guestbook.CreateDto> {
    suspend fun findByName(name: String): Guestbook?
}
