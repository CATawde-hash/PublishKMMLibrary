import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose.compiler)
    id("maven-publish")
    id("signing")
}

group = "com.github.CATawde-hash"


val artifact = "PublishKMMLibrary"
val pkgUrl = "https://github.com/CATawde-hash/PublishKMMLibrary"
val gitUrl = "github.com:CATawde-hash/PublishKMMLibrary.git"


repositories {
    google()
    mavenCentral()
}


kotlin {
  /*  androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }*/
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {  }
        iosMain.dependencies {  }
    }
}


android {
    namespace = "com.example.publishkmmlibrary"
    /*compileSdk = 34
    defaultConfig {
        minSdk = 24
    }*/
    compileSdk = 32
    defaultConfig {
        minSdk = 22
        targetSdk = 34
        multiDexEnabled = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    sourceSets {
        getByName("main") {
            manifest.srcFile("src\\androidMain\\AndroidManifest.xml")
            java.srcDirs("src\\androidMain\\kotlin")
            res.srcDirs("src\\androidMain\\res")
        }
    }
}




