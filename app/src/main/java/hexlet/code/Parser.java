package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> pars(String content, String format) throws IOException {
        ObjectMapper mapper;
        switch (format.toLowerCase()) {

            case "yml", "yaml" -> {
                mapper = new YAMLMapper();
            }
            case "json" -> {
                mapper = new JsonMapper();
            }
            default -> throw new IOException("Unvaliable format " + format);
        }
        return mapper.readValue(content, new TypeReference<>() { }); // Тут парсинг идёт
    }
}
