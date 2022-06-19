import org.gradle.api.artifacts.ProjectDependency
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project
import org.gradle.plugin.use.PluginDependenciesSpec

private fun PluginDependenciesSpec.plugin(plugin: String) = id(plugin)

fun PluginDependenciesSpec.plugins(vararg plugins: String) = plugins.forEach { plugin(it) }

private fun DependencyHandlerScope.implementation(dependency: String) = "implementation"(dependency)

fun DependencyHandlerScope.implementations(vararg dependencies: String) =
    dependencies.forEach { implementation(it) }

private fun DependencyHandlerScope.testImplementation(testDependency: String) = "testImplementation"(testDependency)

fun DependencyHandlerScope.testImplementations(vararg testDependencies: String) =
    testDependencies.forEach { testImplementation(it) }

private fun DependencyHandlerScope.implementation(dependency: ProjectDependency) =
    "implementation"(dependency)

fun DependencyHandlerScope.implementationProjects(vararg dependencies: String) {
    dependencies.map { project(it) }
        .forEach { implementation(it) }
}

private fun DependencyHandlerScope.kapt(dependency: String) = "kapt"(dependency)

fun DependencyHandlerScope.kapts(vararg dependencies: String) = dependencies.forEach { kapt(it) }
