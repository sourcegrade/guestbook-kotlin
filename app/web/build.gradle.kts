plugins {
    id("kotlin-jvm.base-conventions")
    id("kotlin-js.base-conventions")
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    commonMainApi(project(":guestbook-kotlin-domain"))
    commonMainApi(libs.redux)
    commonMainApi(libs.ktor.resources)
}
