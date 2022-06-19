buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Depends.Plugins.androidGradlePlugin)
        classpath(Depends.Plugins.kotlinGradlePlugin)
        //classpath(Depends.Plugins.hiltGradlePlugin)
        classpath(Depends.Plugins.navigationGradlePlugin)
    }
}

allprojects {
    repositories {

    }
}
