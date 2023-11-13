plugins {
    id("com.android.application")
}


android {
    namespace = "com.example.androidrealestateproject"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.androidrealestateproject"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        dataBinding = true
    }
}



dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.room:room-common:2.5.2")
    implementation("androidx.room:room-runtime:2.5.2")
    implementation ("com.google.code.gson:gson:2.8.9")
    implementation ("com.squareup.picasso:picasso:2.8")
    implementation ("pub.devrel:easypermissions:3.0.0")
    implementation("io.github.ParkSangGwon:tedimagepicker:1.4.2")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))





    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    annotationProcessor("androidx.room:room-compiler:2.5.2")
}