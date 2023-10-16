plugins {
    java
    id("org.springframework.boot") version "3.2.0-M2"
    id("io.spring.dependency-management") version "1.1.0"
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
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
