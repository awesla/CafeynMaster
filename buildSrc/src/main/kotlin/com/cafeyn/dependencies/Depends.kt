object Depends {

    object Plugins {
        const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradle}"
        const val kotlinGradlePlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
        const val navigationGradlePlugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navKtxVersion}"
    }

    object Android {
        const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

        /** Android x */
        const val supportAppCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val androidXHiltCompiler = "androidx.hilt:hilt-compiler:${Versions.androidXHilt}"
        const val navigationFragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"


        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    }

    object testAndroid {
    }
}
