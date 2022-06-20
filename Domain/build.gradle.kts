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
    implementations(
        Depends.Android.kotlinStdLib,
        Depends.Android.retrofitGson,
        Depends.Android.hiltAndroid,
        Depends.Android.coroutinesCore,
        Depends.Android.coroutinesAndroid
    )

    kapts(
        Depends.Android.hiltCompiler,
    )

    testImplementations(
        Depends.testAndroid.junitTest,
        Depends.testAndroid.kotlinTest,
        Depends.testAndroid.mockk,
        Depends.testAndroid.mockkAgentJvm,
        Depends.testAndroid.kotlinCoroutineTest
    )
}