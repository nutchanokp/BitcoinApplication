//ext {
//    kotlin_version = "1.7.20"
//    nav_version = "2.5.3"
//    viewmodel_version = '2.2.0'
//}

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
