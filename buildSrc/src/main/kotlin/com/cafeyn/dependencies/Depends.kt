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

        /** https://github.com/google/dagger */
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"

        /** https://square.github.io/retrofit/ */
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitRxjava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

        /** https://square.github.io/okhttp/ */
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val okhttpLoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

        /** https://github.com/Kotlin/kotlinx.coroutines */
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

        /** https://developer.android.com/jetpack/androidx/releases/room */
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

        /** https://coil-kt.github.io/coil/ */
        const val coilKt = "io.coil-kt:coil:${Versions.coil}"
    }

    object testAndroid {
        /** https://github.com/junit-team/junit4 */
        const val junitTest = "junit:junit:${Versions.junit}"
        const val kotlinTest = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"

        /** https://mockk.io */
        const val mockk = "io.mockk:mockk:${Versions.mockk}"
        const val mockkAgentJvm = "io.mockk:mockk-agent-jvm:${Versions.mockk}"

        const val kotlinCoroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutineTest}"
    }
}
