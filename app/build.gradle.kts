plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.android.photogallery"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.android.photogallery"
        minSdk = 26
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.fragment) //Fragment
    implementation(libs.androidx.recyclerview) //RecyclerView
    implementation(libs.androidx.viewmodel) //ViewModel
    implementation(libs.androidx.lifecycle) //Lifecycle
    implementation(libs.square.retrofit)    //Retrofit
    implementation(libs.square.okhttp3)     //okhttp3
    implementation(libs.android.coroutine) //Android Coroutine
    implementation(libs.converter.scalars) //Converter

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}