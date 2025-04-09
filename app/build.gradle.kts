plugins {
    java // Подключаем плагин для Java
    application // Подключаем плагин application
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral() // Используем Maven Central для зависимостей
}

dependencies {
    // Используем BOM для JUnit Jupiter
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform() // Используем платформу JUnit 5
}

application {
    mainClass.set("hexlet.code.App") // Указываем главный класс
}