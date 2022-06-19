plugins {
    plugins(
        Config.Plugins.androidApplication,
        Config.Plugins.kotlinAndroid,
        Config.Plugins.daggerHiltPlugin,
        Config.Plugins.Kapt
    )
}

android {

    signingConfigs {
        getByName("debug") {
            storeFile = file("../debug.keystore")
            keyAlias = "AndroidDebugKey"
            keyPassword = "android"
            storePassword = "android"
        }
    }

    compileSdk = Versions.Android.compileSdkVersion
    defaultConfig {
        applicationId = Config.Application.applicationId
        targetSdk = Versions.Android.targetSdkVersion
        minSdk = Versions.Android.minSdkVersion

        versionCode = Versions.Android.appVersionCode

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = true
        }

        getByName("release") {
            isDebuggable = false
            isShrinkResources = true
            isMinifyEnabled = true

        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementationProjects(
        ":Presentation"
    )

    implementations(
        Depends.Android.hiltAndroid
    )

    kapts(
        Depends.Android.hiltCompiler,
        Depends.Android.androidXHiltCompiler
    )
}