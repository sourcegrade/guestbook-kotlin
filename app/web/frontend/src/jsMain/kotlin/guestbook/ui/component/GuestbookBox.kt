package guestbook.ui.component

import guestbook.domain.Guestbook
import mui.material.Card
import mui.material.CardContent
import mui.material.Typography
import mui.material.styles.TypographyVariant
import mui.system.sx
import react.FC
import react.Props
import web.cssom.Color
import web.cssom.pct
import web.cssom.px

external interface GuestbookBoxProps : Props {
    var guestbook: Guestbook
}

val GuestbookBox = FC<GuestbookBoxProps> { props ->
    Card {
        sx {
            width = 100.pct
        }
        CardContent {
            Typography {
                sx {
                    fontSize = 14.px
                    color = Color("text.secondary")
                }
                +"Guestbook"
            }
            Typography {
                variant = TypographyVariant.h5
                +props.guestbook.name
            }
            Typography {
                sx {
                    fontSize = 10.px
                    color = Color("text.secondary")
                }
                +props.guestbook.id
            }
        }
    }
}
