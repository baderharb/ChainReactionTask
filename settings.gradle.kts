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
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "ChainReactionTask"
include(":app")

include(":core:component")
include(":core:navigation")
include(":core:network")
include(":core:storage")

include(":features:auth:domain")
include(":features:auth:presentation")

include(":features:main:presentation")

include(":features:more:presentation")

include(":features:news:data")
include(":features:news:domain")
include(":features:news:presentation")

include(":features:splash:domain")
include(":features:splash:presentation")