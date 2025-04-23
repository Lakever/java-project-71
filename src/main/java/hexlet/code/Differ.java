package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws IOException {
        Map<String, Object> data1 = PathFile.fromFile(filePath1);
        Map<String, Object> data2 = PathFile.fromFile(filePath2);
        return generateDiff(data1, data2, 1);
    }

    private static String generateDiff(Map<String, Object> data1, Map<String, Object> data2, int depth) {
        StringBuilder result = new StringBuilder();
        // Отступы в зависимости от вложенности
        String indent = "  ".repeat(depth);
        String baseIndent = "  ".repeat(depth - 1);

        result.append(baseIndent).append("{\n");

        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());

        for (String key : keys) {
            Object val1 = data1.get(key);
            Object val2 = data2.get(key);

            if (!data2.containsKey(key)) {
                result.append(indent).append("- ").append(key).append(": ").append(val1).append("\n");
            } else if (!data1.containsKey(key)) {
                result.append(indent).append("+ ").append(key).append(": ").append(val2).append("\n");
            } else if (isNested(val1, val2)) {
                String nested = generateDiff((Map<String, Object>) val1, (Map<String, Object>) val2, depth + 2);
                result.append(indent).append("  ").append(key).append(": ").append(nested).append("\n");
            } else if (!val1.equals(val2)) {
                result.append(indent).append(" - ").append(key).append(": ").append(val1).append("\n");
                result.append(indent).append(" + ").append(key).append(": ").append(val2).append("\n");
            } else {
                result.append(indent).append("   ").append(key).append(": ").append(val1).append("\n");
            }
        }
        result.append(baseIndent).append("}");
        return result.toString();
    }

    private static boolean isNested(Object val1, Object val2) {
        return val1 instanceof Map && val2 instanceof Map; // Мы убедились, что объект вложенный и имеет Map
    }
}
