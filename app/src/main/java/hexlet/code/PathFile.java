package hexlet.code;

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
    public static Map<String, Object> fromFile(String fileName) throws IOException {
//        ClassLoader classLoader = PathFile.class.getClassLoader();
//        try (var inputStream = classLoader.getResourceAsStream("files/" + fileName)) {
//            if (inputStream == null) {
//                throw new IOException("Resource not found: " + fileName);
//            }
//
//            String content = new String(inputStream.readAllBytes());
//            String format = getFormat(fileName);
//            return Parser.pars(content, format);
//        }

//        var path = getFilesPath(fileName);
//        String content = Files.readString(path);
//        return Parser.pars(content, getFormat(fileName));
        Path path = Paths.get(fileName);
        if (!path.isAbsolute()) {
            path = getFilesPath(fileName);
        }
        String content = Files.readString(path);
        return Parser.pars(content, getFormat(fileName));
    }
// Читаем файлы в директории files
    private static Path getFilesPath(String fileName) {
        return Paths.get("src", "main", "resources", "files", fileName)
                .toAbsolutePath()
                .normalize();
    }



//    private static String readFixture(String fileName) throws IOException {
//        var result = Files.readString(getFixturePath(fileName));
//        return result.trim();
//    }

    public static String getFormat(String filePath) {
        var afterDotIndex = filePath.lastIndexOf(".");
        if (afterDotIndex == -1) {
            return "Not found format";
        } else {
            return filePath.substring(afterDotIndex + 1).toLowerCase();
        }

    }
}
