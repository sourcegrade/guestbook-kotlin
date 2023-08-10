plugins {
    id("kotlin-jvm.base-conventions")
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ktor)
}

dependencies {
    commonMainImplementation(project(":guestbook-kotlin-app-web"))
    commonMainImplementation(project(":guestbook-kotlin-db"))
    jvmMainImplementation(libs.bundles.ktor.server)
    jvmMainRuntimeOnly(libs.logging.impl)
}

application {
    mainClass = "guestbook.MainKt"
}

tasks {
    val runDir = file("build/run")
    withType<JavaExec> {
        doFirst {
            runDir.mkdirs()
        }
        workingDir = runDir
    }
}
