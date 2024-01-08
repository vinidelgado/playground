@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.detekt)
    alias(libs.plugins.kapt)
    alias(libs.plugins.kover)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.roborazzi.plugin)
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    namespace = "com.vini.playground"

    defaultConfig {
        applicationId = "com.vini.playground"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
        }

        getByName("release") {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Required for annotation processing plugins like Dagger
    kapt {
        generateStubs = true
        correctErrorTypes = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()

        // Enable Coroutines and Flow APIs
        freeCompilerArgs =
            freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.FlowPreview"
    }

    lint {
        abortOnError = true
        disable.addAll(
            listOf(
                "MissingTranslation",
                "OldTargetApi",
                "GradleDependency",
                "ObsoleteLintCustomCheck"
            )
        )
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    testOptions.unitTests.isIncludeAndroidResources = true


    packaging.resources {
        // Multiple dependency bring these files in. Exclude them to enable
        // our test APK to build (has no effect on our AARs)
        excludes += "/META-INF/AL2.0"
        excludes += "/META-INF/LGPL2.1"
    }
}

koverReport {
    verify {
        rule {
            isEnabled = true
            bound {
                minValue = 60
            }
        }
    }
    defaults {
        html {
            title = "Playground"
            onCheck = false
            setReportDir(layout.buildDirectory.dir("reports/coverage"))
        }
    }
    filters {
        excludes {
            classes(
                "*Activity",
                "*Activity\$*",
                "*.BuildConfig",
                "*Hilt*",
                "*Factory*",
                "*Injector",
                "*Database*",
                "*Dao*",
                "*Module*",
                "*Application",
                "*Worker*",
                "*Composable*",
            )
            packages(
                "*.di",
                "com.vini.playground.ui.theme"
            )
            annotatedBy(
                "*Preview",
                "*Stable",
                "*Database",
                "*Module",
                "*Generated",
                "*UiModePreviews"
            )
        }
    }
}


dependencies {
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.activity.compose)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.runtime.livedata)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.google.android.material)

    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.util)
    implementation(libs.androidx.compose.ui.viewbinding)
    implementation(libs.androidx.compose.ui.googlefonts)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.runtime)
    implementation(libs.jacoco)

    implementation(libs.coil.kt.compose)
    // Hilt - dependency injection
//    implementation(libs.androidx.hilt.navigation.compose)
//    implementation(libs.hilt.android)
//    kapt(libs.hilt.compiler)
//    kapt(libs.hilt.ext.compiler)

    debugImplementation(libs.androidx.compose.ui.test.manifest)

    testImplementation(libs.roborazzi)
    testImplementation(libs.roborazzi.compose)
    testImplementation(libs.roborazzi.junit)
    testImplementation(libs.robolectric)
    testImplementation(libs.androidx.test.ext.junit)
    testImplementation(libs.androidx.test.espresso.core)
    testImplementation(platform(libs.androidx.compose.bom))
    testImplementation(libs.androidx.compose.ui.test.junit4)
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.test.rules)
    debugImplementation(libs.androidx.ui.test.manifest)
}