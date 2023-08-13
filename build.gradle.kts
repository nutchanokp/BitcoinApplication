buildscript {
    extra.apply {
        set("versionCode", 1)
        set("versionName", "1.0")
        set("minSdkVersion", 25)
        set("targetSdkVersion", 34)
        set("applicationId", "com.nut.cdev.bitcoinapplication")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.0.0")
        classpath("io.realm:realm-gradle-plugin:10.16.1")
    }
}
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.android.library") version "8.1.0" apply false
}