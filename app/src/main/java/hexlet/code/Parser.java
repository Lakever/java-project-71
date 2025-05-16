package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Parser {

    public static Map<String, Object> pars(String content, String format) throws IOException {
//        String content = Files.readString(path);
        ObjectMapper mapper;

        switch (format.toLowerCase()) {
            case "stylish" -> mapper = new ObjectMapper();
            case "yml", "yaml" -> mapper = new YAMLMapper();
            case "json" -> mapper = new JsonMapper();
            default -> throw new IOException("Unvaliable format " + format);
        }
//        if (path.toString().endsWith(".json")) {
//            mapper = new ObjectMapper();
//        } else if (path.toString().endsWith(".yaml") || path.toString().endsWith(".yml")) {
//            mapper = new YAMLMapper();
//        } else {
//            throw new IOException("Unsupported file format: " + path);
//        }

        return mapper.readValue(content, new TypeReference<>() { }); // Тут парсинг идёт
    }
}
