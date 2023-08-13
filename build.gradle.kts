// Top-level build file where you can add configuration options common to all sub-projects/modules.
//allprojects {
//    ext {
//        set("minSdkVersion", 25)
//        set("targetSdkVersion", 34)
//    }
//}
buildscript {
    extra.apply {
        set("minSdkVersion", 25)
        set("targetSdkVersion", 34)
        set("applicationId", "com.nut.cdev.bitcoinapplication")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.0.0")
        classpath("io.realm:realm-gradle-plugin:10.15.1")
    }
//    repositories {
//        google()
//        mavenCentral()
//        gradlePluginPortal()
////        maven {url =("https://jitpack.io")}
//    }
}
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.android.library") version "8.1.0" apply false
}