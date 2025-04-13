plugins {
    java // Подключаем плагин для Java
    application // Подключаем плагин application
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral() // Используем Maven Central для зависимостей
}

dependencies {

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.6.3")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.16.1")
//    checkstyle("com.puppycrawl.tools:checkstyle:${checkstyle.toolVersion}")
}


tasks.test {
    useJUnitPlatform() // Используем платформу JUnit 5
}

application {
    mainClass.set("hexlet.code.App") // Указываем главный класс
}
//checkstyle {
//    toolVersion = '10.12.1' // Актуальная версия на момент ответа
//    configDirectory = file("${rootDir}/config/checkstyle") // Указываем директорию
//
//    // Настройки отчетов
//    reportsDir = file("${buildDir}/reports/checkstyle")
//    ignoreFailures = false // Фаил билд при ошибках
//}