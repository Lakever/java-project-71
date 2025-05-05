package hexlet.code;

import org.junit.jupiter.api.Test;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", "DifferTestDirect", fileName)
                .toAbsolutePath()
                .normalize();
    }

//    @Test
//    public void testParseValidJson() throws IOException {
//        String testFileName = "file2Test.json";
//        Path testFilePath = getFixturePath(testFileName);
//
//        assertTrue(Files.exists(testFilePath));
//
//        Map<String, Object> expected = Map.of(
//                "host", "hexlet.io",
//                "timeout", 20,
//                "verbose", true
//        );
//
//        Map<String, Object> actual = PathFile.fromFile(testFilePath.toString());
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testParseValidYaml() throws IOException {
//        String testFileName = "file2Test.yaml";
//        Path testFilePath = getFixturePath(testFileName);
//
//        assertTrue(Files.exists(testFilePath));
//
//        Map<String, Object> expected = Map.of(
//                "host", "hexlet.io",
//                "timeout", 20,
//                "verbose", true
//        );
//
//        Map<String, Object> actual = PathFile.fromFile(testFilePath.toString());
//
//        assertEquals(expected, actual);
//    }

    @Test
    public void testParseNestingJson() throws IOException {
        String testFileName = "file2TestNesting.json";
        Path testFilePath = getFixturePath(testFileName); // вот эта штука берет путь до файла

        assertTrue(Files.exists(testFilePath), "File not found");

        Map<String, Object> expected = new HashMap<>();
        expected.put("setting1", "Another value");
        expected.put("setting2", 300);
        expected.put("setting3", "none");
        expected.put("key2", "value2");
        expected.put("numbers1", List.of(1, 2, 3, 4));
        expected.put("numbers2", List.of(22, 33, 44, 55));
        expected.put("id", null);
        expected.put("default", List.of("value1", "value2"));
        expected.put("checked", true);
        expected.put("numbers4", List.of(4, 5, 6));
        expected.put("chars1", List.of("a", "b", "c"));
        expected.put("chars2", false);
        //а тут добавлю вложенный объект
        Map<String, Object> obj1 = new HashMap<>();
        obj1.put("nestedKey", "value");
        obj1.put("isNested", true);

        expected.put("obj1", obj1);

        Map<String, Object> actual = PathFile.fromFile(testFilePath.toString());

        assertEquals(expected, actual);
    }

    @Test
    public void testParseNestingYaml() throws IOException {
        String testFileName = "file2TestNestingYaml.yaml";
        Path testFilePath = getFixturePath(testFileName); // вот эта штука берет путь до файла

        assertTrue(Files.exists(testFilePath));

        Map<String, Object> expected = new HashMap<>();
        expected.put("setting1", "Another value");
        expected.put("setting2", 300);
        expected.put("setting3", "none");
        expected.put("key2", "value2");
        expected.put("numbers1", List.of(1, 2, 3, 4));
        expected.put("numbers2", List.of(22, 33, 44, 55));
        expected.put("id", null);
        expected.put("default", List.of("value1", "value2"));
        expected.put("checked", true);
        expected.put("numbers4", List.of(4, 5, 6));
        expected.put("chars1", List.of("a", "b", "c"));
        expected.put("chars2", false);
        //а тут добавлю вложенный объект
        Map<String, Object> obj1 = new HashMap<>();
        obj1.put("nestedKey", "value");
        obj1.put("isNested", true);
        // и положу его к остальным
        expected.put("obj1", obj1);

        Map<String, Object> actual = PathFile.fromFile(testFilePath.toString());

        assertEquals(expected, actual);
    }
}
