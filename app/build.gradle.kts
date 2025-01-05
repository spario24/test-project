plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.android.paginationverticalscroll"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.android.paginationverticalscroll"
        minSdk = 24
        targetSdk = 34
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

    sourceSets {
//        main {
//            res.srcDirs =
//                [
//                    file("src/main/res/layouts/").listFiles(),
//                    'src/main/res/layouts/activities',
//                    'src/main/res/layouts/fragments,
//                    'src/main/res/layouts/adapters,
//                    'src/main/res/layouts',
//                    'src/main/res'
//            ]
//        }
        getByName("main") {
            res.srcDirs(
                "src/main/res/layouts/activities",
                "src/main/res/layouts/fragments",
                "src/main/res/layouts/adapters",
                "src/main/res/layouts",
                "src/main/res"
            )
        }

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Paging Library
//    implementation ("android.arch.paging:runtime:1.0.1")
    val paging_version = "3.3.5"
    implementation ("androidx.paging:paging-runtime:$paging_version")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2") // LiveData


}