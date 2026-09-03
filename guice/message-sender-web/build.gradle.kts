plugins {
    id("java")
    application
}

group = "com.lughtech"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.lughtech.Application")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:4.1.1")
    implementation("org.springframework.boot:spring-boot-starter-web:4.1.1")
    implementation("com.google.inject:guice:7.0.0")
    implementation("org.apache.logging.log4j:log4j-api:2.24.1")
    implementation("org.apache.logging.log4j:log4j-core:2.24.1")

    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}