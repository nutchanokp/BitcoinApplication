plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("realm-android")
}
//ext {
//    kotlin_version = "1.7.20"
//    nav_version = "2.5.3"
//    viewmodel_version = '2.2.0'
//}
android {
    namespace = "com.nut.cdev.bitcoinapplication"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.nut.cdev.bitcoinapplication"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true

        buildConfigField("String", "BASE_URL", "\"https://api.coindesk.com/\"");
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.majorVersion
    }

    buildFeatures {
        dataBinding = true
        buildConfig = true
    }

}

dependencies {

    implementation(project(":fibonacci"))
    implementation(project(":recyclerview"))
    implementation(project(":validate"))
    implementation(project(":prime_number"))
    implementation(project(":filter_array"))
    implementation(project(":filter_array"))

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("javax.inject:javax.inject:1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Multidex
    implementation("androidx.multidex:multidex:2.0.1")

    // koin
    implementation("io.insert-koin:koin-core:3.4.0")
    implementation("io.insert-koin:koin-android:3.4.0")

    // Networking
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    // Lifecycle
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

}