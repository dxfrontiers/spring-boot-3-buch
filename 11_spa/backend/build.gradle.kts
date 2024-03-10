plugins {
  java
  id("org.springframework.boot") version "3.2.3"
  id("io.spring.dependency-management") version "1.1.4"
}

group = "de.springboot3.spa"
version = "0.0.1-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.projectlombok:lombok")
  annotationProcessor("org.projectlombok:lombok")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
  useJUnitPlatform()
}

tasks.register<Copy>("processFrontendResources") {
  group = "Frontend"
  description = "Process frontend resources"
  dependsOn(":frontend:assembleFrontend")

  from(project(":frontend").layout
          .projectDirectory.dir("dist"))
  into(project.layout
          .buildDirectory.dir("resources/main/public"))
}

tasks.named("processResources") {
  dependsOn("processFrontendResources")
}
