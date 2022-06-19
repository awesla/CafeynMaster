plugins {
    plugins(
        Config.Plugins.androidLibrary,
        Config.Plugins.kotlinAndroid,
        //Config.Plugins.daggerHiltPlugin,
        Config.Plugins.Kapt
    )
}

android{
    compileSdk = Versions.Android.compileSdkVersion
    defaultConfig {
        targetSdk = Versions.Android.targetSdkVersion
        minSdk = Versions.Android.minSdkVersion
    }
}

dependencies {

    implementationProjects(
        ":Core"
    )
}