import com.android.build.api.dsl.ApplicationExtension
import com.tahhan.convention.ExtensionType
import com.tahhan.convention.configureBuildTypes
import com.tahhan.convention.configureKotlinAndroid
import com.tahhan.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> { //android scope in build.gradle.kts
                defaultConfig {
                    applicationId = libs.findVersion("projectApplicationId").get().toString()
                    targetSdk = libs.findVersion("projectTargetSdkVersion").get().toString().toInt()

                    versionCode = libs.findVersion("projectVersionCode").get().toString().toInt()
                    versionName = libs.findVersion("projectVersionName").get().toString()

                    configureKotlinAndroid(this@configure)
                }

                configureBuildTypes(
                    commonExtension = this,
                    ExtensionType.APPLICATION
                )
            }
        }
    }
}