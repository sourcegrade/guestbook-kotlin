package guestbook.web.http

import io.ktor.resources.Resource

@Resource("/api/v1/guestbook")
class GuestbookRoute {
    @Resource("{id}")
    class ById(val id: String)
}
