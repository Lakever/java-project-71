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
    public static Map<String, Object> fromFile(String way) throws IOException {
        Path path = Paths.get(way);

        // Если указанный путь не существует — пробуем src/main/resources/files/
        if (!Files.exists(path)) {
            path = Paths.get("src/main/resources/files", way);
        }

        path = path.toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new IOException("File not found: " + path);
        }

        if (Files.isDirectory(path)) {
            throw new IOException("Path is a directory: " + path);
        }

        return Parser.pars(path);
    }
}
