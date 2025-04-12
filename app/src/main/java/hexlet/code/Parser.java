package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> pars(String way) throws IOException {
        // Правильный путь (относительно корня проекта)
//        String readFilePath = "src/main/resources/files/file1.json";
        Path path = Paths.get(way).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new IOException("File not found: " + path);
        }
        if (Files.isDirectory(path)) {
            throw new IOException("Path is a directory: " + path);
        }

        String content = Files.readString(path); // reading ffile

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        map = mapper.readValue(content, new TypeReference<Map<String, Object>>() {}); // parsing

        return map;
    }
}
