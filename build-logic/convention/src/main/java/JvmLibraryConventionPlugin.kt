import com.android.build.api.dsl.LibraryExtension
import com.tahhan.convention.ExtensionType
import com.tahhan.convention.configureBuildTypes
import com.tahhan.convention.configureKotlinAndroid
import com.tahhan.convention.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("org.jetbrains.kotlin.jvm")
            }

            configureKotlinJvm()
        }
    }
}