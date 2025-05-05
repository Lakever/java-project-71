package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormat;

import java.util.List;

import static hexlet.code.formatters.PlainFormat.plainFormat;
import static hexlet.code.formatters.StylishFormat.stylishFormat;


public class Formatter {

    public static String buildFormat(List<DiffChange> differ, int depth, String style) throws JsonProcessingException {
        switch (style) {
            case "stylish" -> {
                return stylishFormat(differ, depth);
            }
            case "plain" -> {
                return plainFormat(differ, depth);
            }
            case "json" -> {
                return JsonFormat.jsonFormat(differ, depth);
            }
            default -> throw new IllegalArgumentException("Unsupported style: " + style);

        }
    }
}
