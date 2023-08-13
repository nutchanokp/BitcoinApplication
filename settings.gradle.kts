pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "BitcoinApplication"
include(":app")
include(":fibonacci")
include(":validate")
include(":prime_number")
include(":filter_array")
include(":recyclerview")
include(":number_picker")
