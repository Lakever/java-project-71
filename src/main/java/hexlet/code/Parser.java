package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
// получаем путь из который указывает пользователь в параметр через filePath-way
//
public class Parser {
    public static Map<String, Object> pars(String way) throws IOException {
//        String readFilePath = "src/main/resources/files/file1.json";
        Path path = Paths.get(way).toAbsolutePath().normalize();

        if (!Files.exists(path)) { // если файла по этому пути нет -> исключение
            throw new IOException("File not found: " + path);
        }
        if (Files.isDirectory(path)) { // проверка на директорию
            throw new IOException("Path is a directory: " + path);
        }

        String content = Files.readString(path); // reading ffile

        ObjectMapper mapper = new ObjectMapper();// объект парсера
        Map<String, Object> map = new HashMap<>();
        // парсим прочитанное в файле и заносим в map
        map = mapper.readValue(content, new TypeReference<Map<String, Object>>() {}); // parsing

        return map;
    }
}
