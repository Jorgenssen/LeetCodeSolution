#!/usr/bin/env kotlin
@file:DependsOn("io.github.typesafegithub:github-workflows-kt:1.13.0")

import io.github.typesafegithub.workflows.actions.actions.CheckoutV4
import io.github.typesafegithub.workflows.actions.actions.SetupJavaV4
import io.github.typesafegithub.workflows.domain.RunnerType
import io.github.typesafegithub.workflows.domain.actions.CustomAction
import io.github.typesafegithub.workflows.domain.triggers.Push
import io.github.typesafegithub.workflows.dsl.workflow
import io.github.typesafegithub.workflows.yaml.writeToFile

val generateReportAction = CustomAction(
    actionOwner = "dorny",
    actionName = "test-reporter",
    actionVersion = "v1",
    inputs = linkedMapOf(
        "name" to "Maven Test Report",
        "path" to "target/surefire-reports/*.xml",
        "reporter" to "java-junit",
        "fail-on-error" to "true"
    )
)

workflow(
    name = "Java CI with Maven from kotlin",
    on = listOf(Push(branches = listOf("main"))),
    sourceFile = __FILE__.toPath(),
) {
    job(
        id = "BuildAndTest",
        name = "Build And Test",
        runsOn = RunnerType.UbuntuLatest
    ) {
        uses(name = "Check out", action = CheckoutV4())
        uses(name = "Set up SDK 17", action = SetupJavaV4(
            javaVersion = "17",
            distribution = SetupJavaV4.Distribution.Temurin,
            cache = SetupJavaV4.BuildPlatform.Maven))
        run(name = "Build and Test", command = "./mvnw --batch-mode -Dmaven.test.failure.ignore=true clean package")
        uses(name = "Report", action = generateReportAction)
    }
}.writeToFile()