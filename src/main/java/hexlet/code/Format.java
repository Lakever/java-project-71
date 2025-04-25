package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

import static hexlet.code.Differ.generateDiff;

public class Format {
    @SuppressWarnings("unchecked")
    public static String stylish(Map<String, Object> data1, Map<String, Object> data2, Integer depth) {
         var style = "stylish";
        StringBuilder result = new StringBuilder();
        String indent = "  ".repeat(depth);      // базовый отступ
        String markerIndent = indent.substring(2); // отступ до знака

        result.append(indent.substring(2)).append("{\n");

        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());

        for (String key : keys) {
            Object val1 = data1.get(key);
            Object val2 = data2.get(key);

            if (!data2.containsKey(key)) {
                result.append(markerIndent).append("  - ").append(key).append(": ").append(val1).append("\n");
            } else if (!data1.containsKey(key)) {
                result.append(markerIndent).append("  + ").append(key).append(": ").append(val2).append("\n");
            } else if (isNested(val1, val2)) {
                String nested = generateDiff((Map<String, Object>) val1, (Map<String, Object>) val2, depth + 2, style);
                result.append(indent).append("  ").append(key).append(": ").append(nested).append("\n");
            } else if (!Objects.equals(val1, val2)) {
                result.append(markerIndent).append("  - ").append(key).append(": ").append(val1).append("\n");
                result.append(markerIndent).append("  + ").append(key).append(": ").append(val2).append("\n");
            } else {
                result.append(indent).append("  ").append(key).append(": ").append(val1).append("\n");
            }
        }
        result.append(indent.substring(2)).append("}");
        return result.toString();
    }

    private static boolean isNested(Object val1, Object val2) {
        return false;
    }

    public static String plain(Map<String, Object> data1, Map<String, Object> data2, int depth) {
        return "ХУЙ";
    }
}
