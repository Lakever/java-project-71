package hexlet.code;

import java.io.IOException;
import java.util.Map;


import static hexlet.code.BuildFormat.build;
import static hexlet.code.Formatter.buildFormat;

public class Differ {


    public static String generate(String filePath1, String filePath2, String style) throws IOException {
        Map<String, Object> data1 = PathFile.fromFile(filePath1);
        Map<String, Object> data2 = PathFile.fromFile(filePath2);
        var differ = build(data1, data2);
        return buildFormat(differ, 1, style);
    }
    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

}
