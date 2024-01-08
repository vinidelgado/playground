plugins {
    alias(libs.plugins.gradle.versions)
    alias(libs.plugins.version.catalog.update)
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

apply(from = "${project.rootDir}/buildscripts/toml-updater-config.gradle")