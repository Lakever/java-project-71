package hexlet.code.formatters;

import hexlet.code.DiffChange;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JsonFormat {

    public static String jsonFormat(List<DiffChange> differ, int depth) {
        StringBuilder builder = new StringBuilder();
        builder.append("[\n");

        for (int i = 0; i < differ.size(); i++) {
            DiffChange item = differ.get(i);
            builder.append("  {\n");
            builder.append("    \"key\": \"").append(item.getKey()).append("\",\n");
            builder.append("    \"type\": \"").append(item.getTypeChange()).append("\"");

            // Для вложенных объектов
            if ("nested".equals(item.getTypeChange())) {
                builder.append(",\n    \"children\": ").append(jsonFormat(item.getChildren(), depth + 1));
            } else {
                if (item.getOldValue() != null) {
                    builder.append(",\n    \"oldValue\": ").append(stringify(item.getOldValue()));
                }
                if (item.getNewValue() != null) {
                    builder.append(",\n    \"newValue\": ").append(stringify(item.getNewValue()));
                }
            }
            builder.append("\n  }");
            if (i != differ.size() - 1) {
                builder.append(",");
            }
            builder.append("\n");
        }

        builder.append("]");
        return builder.toString();
    }
    private static String stringify(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "\"" + value + "\"";
        }
        if (value instanceof Boolean || value instanceof Number) {
            return value.toString();
        }
        if (value instanceof List) {
            return value.toString();
        }
        if (value instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>) value;
            StringBuilder builder = new StringBuilder();
            builder.append("{\n");

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                builder.append("      \"").append(entry.getKey()).append("\": ")
                        .append(stringify(entry.getValue()))
                        .append(",\n");
            }

            if (!map.isEmpty()) {
                builder.setLength(builder.length() - 2);  // убираем последнюю запятую и \n
                builder.append("\n");
            }
            builder.append("    }");  // закрывающая скобка на нужном уровне
            return builder.toString();
        }

        return "\"" + value.toString() + "\"";
    }
}