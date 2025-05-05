package hexlet.code;
import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", "DifferTestDirect", fileName)
                .toAbsolutePath()
                .normalize();
    }


    private static String readFixture(String fileName) throws IOException {
        var result = Files.readString(getFixturePath(fileName));
        return result.trim();
    }
    @Test
    public void testingGenerateJson() throws IOException {
        System.out.println("START");
//        var filePath = getFixturePath("DefferTest.txt"); // получили путь
        var expected = readFixture("DifferTestJson.txt");
        var filePath1 = getFixturePath("file1.json").toString();
        var filePath2 = getFixturePath("file2.json").toString();

        System.out.println(expected);
        var style = "stylish";
        var actual = generate(filePath1, filePath2, style);
        assertEquals(expected, actual, "Something wrong LOOOOOOOOOOOL");
    }

    @Test
    public void testingGenerateYaml() throws IOException {
        System.out.println("START");
//        var filePath = getFixturePath("DefferTest.txt"); // получили путь
        var expected = readFixture("DifferTestYaml.txt");
        var filePath1 = getFixturePath("file1Test.yaml").toString();
        var filePath2 = getFixturePath("file2Test.yaml").toString();

        System.out.println(expected);

        var style = "stylish";
        var actual = generate(filePath1, filePath2, style);
        assertEquals(expected, actual, "Something wrong LOOOOOOOOOOOL");
    }

    @Test
    public void testingGenerateYamltoPlain() throws IOException {
        System.out.println("START");
//        var filePath = getFixturePath("DefferTest.txt"); // получили путь
        var expected = readFixture("DifferTestPlain.txt");
        var filePath1 = getFixturePath("file1TestNestingYaml.yaml").toString();
        var filePath2 = getFixturePath("file2TestNestingYaml.yaml").toString();

        System.out.println(expected);

        var style = "plain";
        var actual = generate(filePath1, filePath2, style);
        assertEquals(expected, actual, "Something wrong LOOOOOOOOOOOL");

    }

    @Test
    public void testingGenerateJsontoPlain() throws IOException {
        System.out.println("START");
//        var filePath = getFixturePath("DefferTest.txt"); // получили путь
        var expected = readFixture("DifferTestPlain.txt");
        var filePath1 = getFixturePath("file1TestNesting.json").toString();
        var filePath2 = getFixturePath("file2TestNesting.json").toString();

        System.out.println(expected);

        var style = "plain";
        var actual = generate(filePath1, filePath2, style);
        assertEquals(expected, actual, "Something wrong LOOOOOOOOOOOL");

    }

    @Test
    public void testingGenerateJsonToJsonFormat() throws IOException {
        System.out.println("START");
//        var filePath = getFixturePath("DefferTest.txt"); // получили путь
        var expected = readFixture("DifferTestJsonToJson.txt");
        var filePath1 = getFixturePath("file1TestNesting.json").toString();
        var filePath2 = getFixturePath("file2TestNesting.json").toString();

        System.out.println(expected);

        var style = "json";
        var actual = generate(filePath1, filePath2, style);
        assertEquals(expected, actual, "Something wrong LOOOOOOOOOOOL");

    }

    @Test
    public void testingGenerateYamlToJsonFormat() throws IOException {
        System.out.println("START");
//        var filePath = getFixturePath("DefferTest.txt"); // получили путь
        var expected = readFixture("DifferTestJsonToJson.txt");
        var filePath1 = getFixturePath("file1TestNestingYaml.yaml").toString();
        var filePath2 = getFixturePath("file2TestNestingYaml.yaml").toString();

        System.out.println(expected);

        var style = "json";
        var actual = generate(filePath1, filePath2, style);
        assertEquals(expected, actual, "Something wrong LOOOOOOOOOOOL");

    }



}
