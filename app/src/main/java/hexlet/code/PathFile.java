package hexlet.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Класс отвечает за чтение файла и выбор подходящего парсера (JSON или YAML).
 * Используется в {@link PathFile} для обработки входных конфигурационных файлов.
 */
public class PathFile {
    public static Map<String, Object> fromFile(String way) throws IOException {
        ClassLoader classLoader = MyClass.class.getClassLoader();
        Path path = Paths.get(way);
        path = path.toAbsolutePath().normalize();

//        if (!Files.exists(path)) {
//            throw new IOException("File not found: " + path);
//        }
//
//        if (Files.isDirectory(path)) {
//            throw new IOException("Path is a directory: " + path);
//        }
//
//        String content = Files.readString(path); // Читает всё содержимое файла в строку.
//        String format = getFormat(way);


        return Parser.pars(content, format);
    }
    public static String getFormat(String filePath) {
        var afterDotIndex = filePath.lastIndexOf(".");
        if (afterDotIndex == -1) {
            return "Not found format";
        } else {
            return filePath.substring(afterDotIndex + 1).toLowerCase();
        }

    }
}
