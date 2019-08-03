plugins {
    `java-library`
//    scala

    id ("scala-profile")

//    id "com.diffplug.gradle.spotless" version "3.10.0"
    //  id "com.github.maiflai.scalatest" version "0.25"
    //  id "org.scoverage" // version "3.1.5"
    //   id 'nebula.optional-base' version '3.0.3'
    //   id "org.junit.platform.gradle.plugin"


}

//sourceSets {
//
//    main {
//        withConvention(ScalaSourceSet::class) {
//            scala.srcDir("src/main/scala")
//        }
//    }
//
//    test {
//        withConvention(ScalaSourceSet::class) {
//            scala {
//                srcDir { "src/test/scala" }
//                exclude(
//                    "**/*Spec.scala",
//                    "**/*Helper*",
//                    "**/*Builder*"
//                )
////            include {'**/*Test.scala'}
//            }
//
//        }
//    }
//
//    sourceSets.create("acceptanceTest") {
//
//        resources {
//            srcDirs("src/specs/resources", "src/test/specs")
//        }
//
//        withConvention(ScalaSourceSet::class) {
//            scala {
//                srcDir("src/specs/scala")
//            }
//
//            scala.srcDir("src/specs/scala")
//        }
//
//        compileClasspath += sourceSets["main"].runtimeClasspath
//        compileClasspath += sourceSets["test"].runtimeClasspath
//    }
//
//}

tasks.create("showPath") {
    val scalaScriptLoc = rootProject.buildDir.parent + "/scala.gradle.kts"
    println("root $scalaScriptLoc")
    println("spath $scalaScriptLoc")
}
//
//task<Test>("acceptanceTest") {
//    group = "verification"
//    description = "Runs Acceptance Tests"
//    testClassesDirs = sourceSets["acceptanceTest"].output.classesDirs
//    classpath += sourceSets["acceptanceTest"].runtimeClasspath
//    mustRunAfter(getTasksByName("test", recursive = false))
//    testLogging {
//        showStandardStreams = true
//    }
//    systemProperties["concordion.output.dir"] = "$reporting.baseDir/spec"
//}
//
//
//
//task<Test>("allTests") {
//    description = "Runs All Unit and Acceptance Tests"
//    dependsOn(getTasksByName("test", false), getTasksByName("acceptanceTest", false))
//    group = "verification"
//}
//
//tasks.getByName("check").dependsOn(tasks.getByName("allTests"))

description = "Core DDO Objects"

dependencies {
    // val acceptanceTestImplementation by getting
    val acceptanceTestImplementation: Configuration by configurations.getting
   
    implementation(group = "com.beachape", name = "enumeratum_2.12", version = "1.5.13")
    implementation(group = "com.typesafe", name = "config", version = "1.3.4")
    implementation(group = "com.github.kxbmap", name = "configs_2.12", version = "0.4.4")
    implementation(group = "com.wix", name = "accord-core_2.12", version = "0.7.3")
    implementation(group = "com.typesafe.scala-logging", name = "scala-logging_2.12", version = "3.9.2")
    implementation(group = "ch.qos.logback", name = "logback-classic", version = "1.2.3") //,optional
    implementation(group = "org.jetbrains", name = "annotations", version = "17.0.0")
    testImplementation(group = "org.scalatest", name = "scalatest_2.12", version = "3.2.0-SNAP10")
    testRuntimeOnly("org.pegdown:pegdown:1.6.0")
    testImplementation(group = "org.mockito", name = "mockito-all", version = "2.0.2-beta")
    //   testImplementation (group= "junit", name= "junit", version="4.12"
    // JUnit 5
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.5.1")
    //  testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.1")
    testRuntime("org.junit.platform:junit-platform-console:1.5.1")
    testImplementation("org.junit.platform:junit-platform-runner:1.5.1")
    acceptanceTestImplementation(group = "org.concordion", name = "concordion", version = "2.2.0")
    acceptanceTestImplementation(group = "org.concordion", name = "concordion-embed-extension", version = "1.2.0")
    acceptanceTestImplementation(
        group = "org.concordion",
        name = "concordion-collapse-output-extension",
        version = "1.0.0"
    )
    testImplementation(group = "com.wix", name = "accord-scalatest_2.12", version = "0.7.3")
    testImplementation(group = "de.neuland-bfi", name = "jade4j", version = "1.2.7")
    testImplementation(group = "net.ruippeixotog", name = "scala-scraper_2.12", version = "2.1.0")
    testCompileOnly(group = "org.jetbrains", name = "annotations", version = "17.0.0")

    implementation(group = "com.geirsson", name = "scalafmt-core_2.12", version = "1.6.0-RC4-11-9e33ebdb")

}


