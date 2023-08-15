package guestbook.domain

import org.sourcegrade.kontour.MutableRepository

interface GuestbookRepository : MutableRepository<Guestbook, Guestbook.CreateDto> {
    suspend fun findByName(name: String): Guestbook?
}
