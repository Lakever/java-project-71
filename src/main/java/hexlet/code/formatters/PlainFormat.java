package hexlet.code.formatters;

import hexlet.code.DiffChange;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PlainFormat {
    public static String plainFormat(List<DiffChange> differ, int depth) {
        StringBuilder builder = new StringBuilder();
        String indent = "  ".repeat(depth);
        String markerIndent = indent.substring(2);

        for (var item : differ) {
            String key = item.getKey();
            String typeChange = item.getTypeChange();
            Object oldValue = item.getOldValue();
            Object newValue = item.getNewValue();
            var children = item.getChildren();

            switch (typeChange) {
                case "added" -> builder.append("Property '").append(key).append("' was added with value: ").append(som(newValue)).append("\n");
                case "removed" -> builder.append("Property '").append(key).append("' was removed").append("\n");
                case "changed" -> {
                    builder.append("Property '").append(key).append("' was updated. From ").append(som(oldValue)).append(" to ").append(som(newValue)).append("\n");
                }
                case "nested" -> builder.append("Property '").append(key).append("' was updated. From ").append(som(children)).append("\n");
            }
        }
        return builder.toString().trim();
    }

    public static String som(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }
        else {
            return value.toString();
        }
    }
}
