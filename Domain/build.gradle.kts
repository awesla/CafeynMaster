plugins {
    plugins(
        Config.Plugins.androidLibrary,
        Config.Plugins.kotlinParselize,
        Config.Plugins.kotlinAndroid,
        Config.Plugins.Kapt
    )
}

android {
    compileSdk = Versions.Android.compileSdkVersion
    defaultConfig {
        targetSdk = Versions.Android.targetSdkVersion
        minSdk = Versions.Android.minSdkVersion
    }
}

dependencies {
}