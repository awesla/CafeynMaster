plugins {
    plugins(
        Config.Plugins.androidLibrary,
        Config.Plugins.kotlinAndroid
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
    implementations(
        Depends.Android.constraint,
        Depends.Android.navigationUiKtx
    )
}