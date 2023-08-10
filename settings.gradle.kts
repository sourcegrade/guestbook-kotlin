dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
    }
}


pluginManagement {
    includeBuild("build-logic")
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "guestbook-kotlin"

sequenceOf(
    "app-web",
    "app-web-backend",
    "app-web-frontend",
    "db",
    "domain",
).forEach {
    val project = ":guestbook-kotlin-$it"
    include(project)
    project(project).projectDir = file(it.replace('-', '/'))
}
