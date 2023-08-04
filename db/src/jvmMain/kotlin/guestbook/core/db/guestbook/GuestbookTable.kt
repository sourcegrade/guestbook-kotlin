package guestbook.core.db.guestbook

import guestbook.domain.Guestbook
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ResultRow

internal object GuestbookTable : UUIDTable("guestbooks") {
    val name = varchar("name", 255).uniqueIndex()
}

internal fun Iterable<ResultRow>.toGuestbook(): Guestbook {
    val first = first()
    return Guestbook(
        id = first[GuestbookTable.id].value,
        name = first[GuestbookTable.name],
        entries = map { it.toGuestbookEntry() },
    )
}
