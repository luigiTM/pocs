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
    implementation("org.eclipse.jetty:jetty-server:12.1.3")
    implementation("org.eclipse.jetty.ee10:jetty-ee10-servlet:12.1.3")
    implementation("com.google.inject:guice:7.0.0")
    implementation("org.apache.logging.log4j:log4j-api:2.24.1")
    implementation("org.apache.logging.log4j:log4j-core:2.24.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.20.0")

    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}