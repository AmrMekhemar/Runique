plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.tahhan.auth.presentation"
}

dependencies {
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
}