plugins {
    id("java")
}

group = "com.lughtech"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.yaml:snakeyaml:2.2")
    implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")
    implementation("org.springframework:spring-context:7.0.7")
    testImplementation("org.springframework:spring-test:7.0.7")
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}