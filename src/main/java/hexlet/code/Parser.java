package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Класс отвечает за чтение файла и выбор подходящего парсера (JSON или YAML).
 * Используется в {@link Parser} для обработки входных конфигурационных файлов.
 */
public class Parser {
    public static Map<String, Object> pars(String way) throws IOException {
        Path path = Paths.get(way).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new IOException("File not found: " + path);
        }
        if (Files.isDirectory(path)) {
            throw new IOException("Path is a directory: " + path);
        }

        return ChooseFileType.fromFile(path);
    }
}