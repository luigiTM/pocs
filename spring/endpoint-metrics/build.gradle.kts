plugins {
	java
	id("org.springframework.boot") version "4.1.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.lughtech"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter:4.1.1")
	implementation("org.springframework.boot:spring-boot-starter-web:4.1.1")
	implementation("org.springframework.boot:spring-boot-starter-aop:3.5.16")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-h2console:4.1.1")

	runtimeOnly("com.h2database:h2")
	}

tasks.withType<Test> {
	useJUnitPlatform()
}
