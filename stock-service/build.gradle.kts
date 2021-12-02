import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.spring") version "1.6.0"
    id ("org.flywaydb.flyway") version "8.0.2"
    id("org.sonarqube") version "2.8"
    id("io.gitlab.arturbosch.detekt") version "1.19.0"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
}

group = "com.epam.contest"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springCloudVersion"] = "2021.0.0-RC1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-webflux:2.6.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.5")
    implementation("org.flywaydb:flyway-core:8.0.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.5.2-native-mt")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth:3.0.4")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("io.projectreactor.kafka:reactor-kafka")
    runtimeOnly("io.r2dbc:r2dbc-postgresql:0.8.10.RELEASE")
    runtimeOnly("org.postgresql:postgresql:42.3.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.6")
    testImplementation("io.projectreactor:reactor-test:3.4.12")
    testImplementation("org.springframework.kafka:spring-kafka-test:2.7.6")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

flyway {
    url = "jdbc:postgresql://localhost:5432/postgres"
    user = "postgres"
    password = "pwd"
}

sonarqube {
    properties {
        property("sonar.core.codeCoveragePlugin", "jacoco")
        property(
            "sonar.coverage.exclusions",
            "**/ControllerAdvice.kt, **/MapperHelper.kt, **/PointsServiceApplication.kt," +
                    "**/dto/**, **/domain/**, **/config/*, **/jooq/**, **/repository/**, **/timeline/**"
        )
    }
}

detekt {
    source = files("src/main/kotlin", "src/test/kotlin")
}

ktlint {
    version.set("0.38.1")
    verbose.set(true)
    outputToConsole.set(true)
    outputColorName.set("RED")
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
    }
}

tasks.named("check") {
    dependsOn(":ktlintCheck")
}
