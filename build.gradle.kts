plugins {
    alias(libs.plugins.gradle.versions)
    alias(libs.plugins.version.catalog.update)
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

//tasks.named<JacocoReport>("jacocoTestReport") {
//    reports {
//        xml.required.set(true)
//        html.required.set(true)
//    }
//}

apply(from = "${project.rootDir}/buildscripts/toml-updater-config.gradle")