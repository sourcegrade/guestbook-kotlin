plugins {
    id("kotlin-jvm.base-conventions")
}

dependencies {
    commonMainApi(project(":guestbook-kotlin-domain"))
    commonMainApi(libs.kontour)
}
