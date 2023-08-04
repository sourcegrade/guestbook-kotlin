package guestbook.ui.page

import guestbook.domain.Guestbook
import guestbook.ui.component.GuestbookBox
import mui.material.Button
import mui.material.ButtonVariant
import mui.material.Grid
import mui.material.Typography
import mui.material.TypographyAlign
import mui.material.styles.TypographyVariant
import mui.system.responsive
import mui.system.sx
import org.sourcegrade.kontour.Crypto
import react.FC
import react.Props
import web.cssom.Auto
import web.cssom.Display
import web.cssom.px
import web.cssom.rem

val guestbooks = listOf(
    Guestbook(
        id = Crypto.randomUUID(),
        name = "Guestbook 1",
        entries = listOf("Item 1", "Item 2"),
    ),
    Guestbook(
        id = Crypto.randomUUID(),
        name = "Guestbook 2",
        entries = listOf("Item 1", "Item 2"),
    ),
    Guestbook(
        id = Crypto.randomUUID(),
        name = "Guestbook 3",
        entries = listOf("Item 1", "Item 2"),
    ),
)

val Home = FC<Props> {
    Typography {
        sx {
            margin = 1.rem
        }
        align = TypographyAlign.center
        variant = TypographyVariant.h4
        +"The Guestbook (Kotlin)"
    }
    Grid {
        sx {
            padding = 12.px
        }
        container = true
        spacing = responsive(3)
        guestbooks.forEach { guestbook ->
            Grid {
                item = true
                // TODO: https://github.com/JetBrains/kotlin-wrappers/issues/1856
                asDynamic().xs = 12
                asDynamic().sm = 6
                asDynamic().md = 4
                asDynamic().lg = 3
                asDynamic().xl = 2
                GuestbookBox {
                    this.guestbook = guestbook
                }
            }
        }
    }
    Button {
        sx {
            display = Display.block
            margin = Auto.auto
        }
        variant = ButtonVariant.outlined
        +"Add Guestbook"
    }
}
