package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.DiffChange;

import java.util.List;


public class JsonFormat {
    private static final ObjectMapper MAPPER = JsonMapper.builder()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .build();

    public static String jsonFormat(List<DiffChange> differ) {
        try {
            return MAPPER.writeValueAsString(differ);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error of serialization in Json");
        }
    }
}



//public static String jsonFormat(List<DiffChange> differ, int depth) {
//    StringBuilder builder = new StringBuilder();
//    builder.append("[\n");
//
//    for (int i = 0; i < differ.size(); i++) {
//        DiffChange item = differ.get(i);
//        builder.append("  {\n");
//        builder.append("    \"key\": \"").append(item.getKey()).append("\",\n");
//        builder.append("    \"type\": \"").append(item.getTypeChange()).append("\"");
//
//
//        if ("nested".equals(item.getTypeChange())) { // Для вложенных объектов
//            builder.append(",\n    \"children\": ").append(jsonFormat(item.getChildren(), depth + 1));
//        } else if ("unchanged".equals(item.getTypeChange())) {
//            builder.append(",\n    \"value\": ").append(stringify(item.getValue()));
//        } else if ("removed".equals(item.getTypeChange())) {
//            builder.append(",\n    \"oldValue\": ").append(stringify(item.getOldValue()));
//        } else if ("added".equals(item.getTypeChange())) {
//            builder.append(",\n    \"newValue\": ").append(stringify(item.getNewValue()));
//        } else {
//            builder.append(",\n    \"oldValue\": ").append(stringify(item.getOldValue()));
//            builder.append(",\n    \"newValue\": ").append(stringify(item.getNewValue()));
//        }
//
//        builder.append("\n  }");
//        if (i != differ.size() - 1) {
//            builder.append(",");
//        }
//        builder.append("\n");
//    }
//
//    builder.append("]");
//    return builder.toString();
//}
//private static String stringify(Object value) {
//    if (value == null) {
//        return "null";
//    }
//    if (value instanceof String) {
//        return "\"" + value + "\"";
//    }
//    if (value instanceof Boolean || value instanceof Number) {
//        return value.toString();
//    }
//    if (value instanceof List) {
//        List<?> list = (List<?>) value;
//        StringBuilder sb = new StringBuilder("[");
//        for (int i = 0; i < list.size(); i++) {
//            sb.append(stringify(list.get(i)));
//            if (i < list.size() - 1) {
//                sb.append(", ");
//            }
//        }
//        sb.append("]");
//        return sb.toString();
//    }
//    if (value instanceof Map) {
//        @SuppressWarnings("unchecked")
//        Map<String, Object> map = (Map<String, Object>) value;
//        StringBuilder builder = new StringBuilder();
//        builder.append("{\n");
//
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            builder.append("      \"").append(entry.getKey()).append("\": ")
//                    .append(stringify(entry.getValue()))
//                    .append(",\n");
//        }
//
//        if (!map.isEmpty()) {
//            builder.setLength(builder.length() - 2);  // убираем последнюю запятую и \n
//            builder.append("\n");
//        }
//        builder.append("    }");  // закрывающая скобка на нужном уровне
//        return builder.toString();
//    }
//
//    return "\"" + value.toString() + "\"";
//}
