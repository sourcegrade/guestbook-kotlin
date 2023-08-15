package guestbook.core.db.guestbook

import guestbook.domain.Guestbook
import guestbook.domain.GuestbookRepository
import org.jetbrains.exposed.sql.Join
import org.jetbrains.exposed.sql.JoinType
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.sourcegrade.kontour.Pagination
import org.sourcegrade.kontour.UUID

object GuestbookRepositoryImpl : GuestbookRepository {
    override suspend fun findByName(name: String): Guestbook? {
        return newSuspendedTransaction {
            createJoin()
                .select { GuestbookTable.name eq name }
                .toGuestbook()
        }
    }

    override suspend fun countAll(): Long {
        return newSuspendedTransaction {
            GuestbookTable.selectAll().count()
        }
    }

    override suspend fun create(item: Guestbook.CreateDto): Guestbook {
        return newSuspendedTransaction {
            GuestbookTable.insert {
                it[name] = item.name
            }.resultedValues?.toGuestbook()
                ?: throw IllegalStateException("Failed to create guestbook")
        }
    }

    override suspend fun paginate(): Pagination<Guestbook> {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: UUID): Guestbook? {
        return newSuspendedTransaction {
            createJoin()
                .select { GuestbookTable.id eq id }
                .toGuestbook()
        }
    }

    override suspend fun exists(id: UUID): Boolean {
        return newSuspendedTransaction {
            GuestbookTable.select { GuestbookTable.id eq id }.count() > 0
        }
    }

    override suspend fun deleteById(id: UUID): Boolean {
        return newSuspendedTransaction {
            GuestbookTable.deleteWhere { GuestbookTable.id eq id } > 0
        }
    }

    private fun createJoin(): Join = GuestbookTable.join(
        GuestbookTable,
        JoinType.INNER,
        GuestbookTable.id,
        GuestbookEntryTable.guestbookId,
    )
}
