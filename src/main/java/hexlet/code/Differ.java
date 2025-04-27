package hexlet.code;

import java.io.IOException;
import java.util.*;

import static hexlet.code.Format.buildFormat;

public class Differ {

    public static String generate(String filePath1, String filePath2, String style) throws IOException {
        Map<String, Object> data1 = PathFile.fromFile(filePath1);
        Map<String, Object> data2 = PathFile.fromFile(filePath2);
        var differ = build(data1, data2);
        return buildFormat(differ, 1, style);
    }

    public static List<DiffChange> build(Map<String, Object> data1, Map<String, Object> data2) {
        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());
        List<DiffChange> diff = new ArrayList<>();

        for (String key : keys) {
            Object val1 = data1.get(key);
            Object val2 = data2.get(key);

            if (!data2.containsKey(key)) {
                diff.add(new DiffChange(key, "removed", val1, null, null));
            } else if (!data1.containsKey(key)) {
                diff.add(new DiffChange(key, "added", null, val2, null));
            } else if (isNested(val1, val2)) {
                List<DiffChange> children = build((Map<String, Object>) val1, (Map<String, Object>) val2);
                diff.add(new DiffChange(key,"nested", null, null, children));
            } else if (!Objects.equals(val1, val2)) {
                diff.add((new DiffChange(key, "changed", val1, val2, null)));
            } else {
                diff.add(new DiffChange(key, "unchanged", val1, val2, null));
            }
        }
        return diff;
    }

    private static boolean isNested(Object val1, Object val2) {
        return val1 instanceof Map && val2 instanceof Map;
    }
}
