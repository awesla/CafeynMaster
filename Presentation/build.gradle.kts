plugins {
    plugins(
        Config.Plugins.androidLibrary,
        Config.Plugins.kotlinAndroid,
        //Config.Plugins.daggerHiltPlugin,
        Config.Plugins.kotlinNavigation,
        Config.Plugins.Kapt,
    )
}

android{
    compileSdk = Versions.Android.compileSdkVersion
    defaultConfig {
        targetSdk = Versions.Android.targetSdkVersion
        minSdk = Versions.Android.minSdkVersion
    }

    flavorDimensions.addAll(listOf("environment"))
    productFlavors {
        create("dev") {
            dimension = "environment"
            buildConfigField("String", "BASE_URL", "\"http://jsonplaceholder.typicode.com\"")
        }
    }

    buildFeatures.viewBinding = true
}

kapt {
    generateStubs = true
}

dependencies {

    implementationProjects(
        ":Core",
        ":Design",
        ":Domain",
        ":Data"
    )

    implementations(
        Depends.Android.kotlinStdLib,
        Depends.Android.supportAppCompat,
        Depends.Android.constraint,
        Depends.Android.navigationFragmentKtx,
        Depends.Android.navigationUiKtx
    )
}