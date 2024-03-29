plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.devtools.ksp") version "1.8.0-1.0.8"
}

apply(rootDir.path + "/dependencies.gradle")
apply(rootDir.path + "/sub_project.gradle")

android {
    namespace = "com.bader.harb.chainreactiontask"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bader.harb.chainreactiontask"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(":features:splash:presentation"))

    implementation(project(":features:main:presentation"))

    implementation(project(":features:auth:presentation"))

    implementation(project(":features:news:presentation"))

    implementation(project(":features:more:presentation"))

    implementation(project(":core:component"))

    implementation(project(":core:storage"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}