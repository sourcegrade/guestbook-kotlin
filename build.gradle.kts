plugins {
    alias(libs.plugins.kotlin.multiplatform)
    id("kotlin-jvm.base-conventions")
}

dependencies {
    commonMainApi(libs.kontour)
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.multiplatform")
}
