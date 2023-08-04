package guestbook.ui

import js.core.jso
import guestbook.ui.page.Home
import react.FC
import react.Props
import react.create
import react.router.RouterProvider
import react.router.dom.createHashRouter

val Routing = FC<Props> {
    RouterProvider {
        router = createHashRouter(
            arrayOf(
                jso {
                    path = "/"
                    element = Home.create()
                },
            ),
        )
    }
}
