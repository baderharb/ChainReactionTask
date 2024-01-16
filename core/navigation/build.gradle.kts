plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.8.0-1.0.8"
}

apply(rootDir.path + "/sub_project.gradle")
apply(rootDir.path + "/dependencies.gradle")

android {
    namespace = "com.bader.harb.chainreactiontask.core.navigation"
}

dependencies {
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
}