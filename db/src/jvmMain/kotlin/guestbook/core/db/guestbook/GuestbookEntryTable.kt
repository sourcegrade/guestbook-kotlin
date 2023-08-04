package guestbook.core.db.guestbook

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

internal object GuestbookEntryTable : Table("guestbook_entries") {
    val guestbookId = reference("guestbook_id", GuestbookTable)
    val message = varchar("message", 255)
}

internal fun ResultRow.toGuestbookEntry(): String = this[GuestbookEntryTable.message]
