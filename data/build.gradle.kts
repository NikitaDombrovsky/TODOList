plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.todolist.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":domain"))
    implementation("androidx.core:core-ktx:1.12.0")
    //implementation("androidx.room:room-ktx:2.5.0")
    //implementation("androidx.room:room-common:2.6.1")
    implementation("androidx.room:room-ktx:2.5.0")
    implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:2.7.0")
    ksp("androidx.room:room-compiler:2.5.0")

    //kapt("androidx.room:room-compiler:2.5.0")
    //androidTestImplementation("androidx.room:room-testing:$rootProject.roomVersion")
/*    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")*/

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    //androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}