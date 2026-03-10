#!/usr/bin/env kotlin
@file:Repository("https://repo.maven.apache.org/maven2/")
@file:DependsOn("io.github.typesafegithub:github-workflows-kt:3.7.0")
@file:Repository("https://bindings.krzeminski.it")
@file:DependsOn("actions:checkout:v4")
@file:DependsOn("actions:setup-java:v4")

import io.github.typesafegithub.workflows.actions.actions.Checkout
import io.github.typesafegithub.workflows.actions.actions.SetupJava
import io.github.typesafegithub.workflows.domain.RunnerType
import io.github.typesafegithub.workflows.domain.actions.CustomAction
import io.github.typesafegithub.workflows.domain.triggers.Push
import io.github.typesafegithub.workflows.domain.triggers.WorkflowDispatch
import io.github.typesafegithub.workflows.dsl.workflow

val generateReportAction = CustomAction(
    actionOwner = "dorny",
    actionName = "test-reporter",
    actionVersion = "v2",
    inputs = linkedMapOf(
        "name" to "Maven Test Report",
        "path" to "target/surefire-reports/*.xml",
        "reporter" to "java-junit",
        "fail-on-error" to "true"
    )
)

workflow(
    name = "Java CI with Maven from kotlin",
    on = listOf(
        Push(branches = listOf("main")),
        WorkflowDispatch()),
    sourceFile = __FILE__,
) {
    job(
        id = "BuildAndTest",
        name = "Build And Test",
        runsOn = RunnerType.UbuntuLatest
    ) {
        uses(name = "Check out", action = Checkout())
        uses(name = "Set up SDK 17", action = SetupJava(
            javaVersion = "17",
            distribution = SetupJava.Distribution.Temurin,
            cache = SetupJava.BuildPlatform.Maven))
        run(name = "Build and Test", command = "./mvnw --batch-mode -Dmaven.test.failure.ignore=true clean test")
        uses(name = "Report", action = generateReportAction)
    }
}
