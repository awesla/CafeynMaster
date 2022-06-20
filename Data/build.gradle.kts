plugins {
    plugins(
        Config.Plugins.androidLibrary,
        Config.Plugins.kotlinAndroid,
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
        ":Core",
        ":Domain",
        ":Network",
    )

    implementations(
        Depends.Android.retrofit,
        Depends.Android.retrofitGson,
        Depends.Android.kotlinStdLib,
        Depends.Android.hiltAndroid,
        Depends.Android.coroutinesCore,
        Depends.Android.roomKtx
    )

    kapts(
        Depends.Android.hiltCompiler,
        Depends.Android.androidXHiltCompiler,
        Depends.Android.roomCompiler
    )

    testImplementations(
        Depends.testAndroid.junitTest,
        Depends.testAndroid.kotlinTest,
        Depends.testAndroid.mockk,
        Depends.testAndroid.mockkAgentJvm,
        Depends.testAndroid.kotlinCoroutineTest
    )
}