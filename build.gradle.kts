plugins {
    java
    application
    `maven-publish`
}

repositories {
    maven {
        url = uri("https://jitpack.io")
    }

    maven {
        url = uri("https://jcenter.bintray.com")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2")
    }
}

dependencies {
    implementation("com.github.kyngs:Logger:89deab2e62")
    implementation("com.github.kyngs:EasyMySQL:1.2-SNAPSHOT")
    implementation("net.dv8tion:JDA:4.2.0_239")
    implementation("com.github.Carleslc:Simple-YAML:1.7.2")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("mysql:mysql-connector-java:8.0.21")
}

group = "xyz.kyngs"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_15
    targetCompatibility = JavaVersion.VERSION_15
}

application {
    mainClass.set("xyz.kyngs.herbot.Bootstrap")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}