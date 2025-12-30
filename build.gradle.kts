plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
    id("org.springframework.boot") version "4.0.1"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.jpa") version "1.8.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "user-service"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {

    /* =========================
       Spring core
       ========================= */
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")


    /* =========================
       Persistence
       ========================= */
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")

    /* =========================
       Kotlin
       ========================= */
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    /* =========================
       Observability
       ========================= */
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    /* =========================
       Tests
       ========================= */
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // Unit tests
    testImplementation("io.mockk:mockk:1.13.10")

    // Integration tests (на будущее)
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")

    testImplementation(platform("org.testcontainers:testcontainers-bom:1.19.3"))
    testImplementation("org.testcontainers:junit-jupiter:1.19.3")
    testImplementation("org.testcontainers:postgresql:1.19.3")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
