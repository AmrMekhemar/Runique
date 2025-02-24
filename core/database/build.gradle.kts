plugins {
    alias(libs.plugins.runique.android.library)
    alias(libs.plugins.runique.android.room)
}

android {
    namespace = "com.tahhan.core.database"
}

dependencies {
    implementation(libs.bundles.koin)
    implementation(libs.org.mongodb.bson)
    implementation(projects.core.domain)
    implementation(libs.androidx.monitor)

}