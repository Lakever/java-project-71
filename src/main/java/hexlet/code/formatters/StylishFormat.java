package hexlet.code.formatters;

import hexlet.code.DiffChange;

import java.util.List;

public class StylishFormat {
    public static String stylishFormat(List<DiffChange> differ, int depth) {
        StringBuilder builder = new StringBuilder();
        String indent = "  ".repeat(depth);
        String markerIndent = indent.substring(2);

        builder.append(markerIndent).append("{\n");

        for (var item : differ) {
            String key = item.getKey();
            String typeChange = item.getTypeChange();
            Object oldValue = item.getOldValue();
            Object newValue = item.getNewValue();
            var children = item.getChildren();

            switch (typeChange) {
                case "added" -> builder.append(markerIndent)
                        .append("  + ")
                        .append(key)
                        .append(": ")
                        .append(newValue)
                        .append("\n");
                case "removed" -> builder.append(markerIndent)
                        .append("  - ")
                        .append(key)
                        .append(": ")
                        .append(oldValue)
                        .append("\n");
                case "unchanged" -> builder.append(indent)
                        .append("  ")
                        .append(key)
                        .append(": ")
                        .append(oldValue)
                        .append("\n");
                case "changed" -> {
                    builder.append(markerIndent)
                            .append("  - ").append(key)
                            .append(": ")
                            .append(oldValue)
                            .append("\n");
                    builder.append(markerIndent)
                            .append("  + ")
                            .append(key)
                            .append(": ")
                            .append(newValue).append("\n");
                }
                case "nested" -> builder.append(markerIndent)
                        .append("  ")
                        .append(key)
                        .append(":  ")
                        .append(children)
                        .append("\n");
                default -> {
                    String def = "";
                }
            }
        }
        builder.append(markerIndent).append("}");
        return builder.toString();
    }
}
