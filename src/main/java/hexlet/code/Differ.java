package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class Differ {

    public static String generate(String filePath1, String filePath2, String style) throws IOException {
        Map<String, Object> data1 = PathFile.fromFile(filePath1);
        Map<String, Object> data2 = PathFile.fromFile(filePath2);

        return generateDiff(data1, data2, 1, style);
    }


    static String generateDiff(Map<String, Object> data1, Map<String, Object> data2, int depth, String style) {
        if (style.equals("stylish")) {
            return Format.stylish(data1,data2, depth);
        } else if (style.equals("plain")) {
            return Format.plain(data1,data2, depth);
        } else {
            return "Not found format";
        }

    }
}