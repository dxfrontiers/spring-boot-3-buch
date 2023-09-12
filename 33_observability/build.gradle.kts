plugins {
    java
    id("org.springframework.boot") version "3.2.0-M2"
    id("io.spring.dependency-management") version "1.1.0"
    id("com.gorylenko.gradle-git-properties") version "2.4.1"
}

group = "de.springboot3"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("io.micrometer:micrometer-tracing")
    implementation("io.micrometer:micrometer-tracing-bridge-otel")
    implementation("io.opentelemetry:opentelemetry-exporter-zipkin")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

springBoot {
    // creates the file build/resources/main/META-INF/build-info.properties which will be picked up
    // by BuildInfoContributor
    buildInfo()
}

tasks {
    val pipelineProperties by registering(WriteProperties::class) {
        outputFile = file("${buildDir}/pipeline.properties")
        encoding = "UTF-8"
        property("pipeline.number", if(System.getenv("PIPELINE_NUMBER") != null) System.getenv("PIPELINE_NUMBER") else "UNKNOWN")
        property("pipeline.url", if(System.getenv("PIPELINE_URL") != null) System.getenv("PIPELINE_URL") else "UNKNOWN")
    }

    processResources {
        from(pipelineProperties)
    }
}