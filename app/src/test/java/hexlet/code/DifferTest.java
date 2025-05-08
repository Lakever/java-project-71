package hexlet.code;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setUp() throws IOException {
        var expectedPlain = readFixture("DifferTestPlain");
        var expectedStylish = readFixture("DifferTestStylish");
        var expectedJson = readFixture("DifferTestJson");

    }

    @Test
    public void generateTest() { // и здесь у нас будет 1 тест на всё приложение

    }
//    private static String exeTest(String fixture, String fileName1, String fileName2, String style) throws IOException {
//        var filePath1 = getFixturePath(fileName1).toString();
//        var filePath2 = getFixturePath(fileName2).toString();
//
//        return generate(filePath1, filePath2, style);
//    }

//    @Test
//    public void testingGenerateJson() throws IOException {
//        var expected = readFixture("DifferTestJson.txt");
//        var filePath1 = getFixturePath("file1.json").toString();
//        var filePath2 = getFixturePath("file2.json").toString();
//
//        System.out.println(expected);
//        var style = "stylish";
//        var actual = generate(filePath1, filePath2, style);
//        assertEquals(expected, actual, "Something wrong LOOOOOOOOOOOL");
//    }

//    @Test
//    public void testingGenerateYaml() throws IOException {
//        var expected = readFixture("DifferTestYaml.txt");
//        var filePath1 = getFixturePath("file1Test.yaml").toString();
//        var filePath2 = getFixturePath("file2Test.yaml").toString();
//
//        System.out.println(expected);
//
//        var style = "stylish";
//        var actual = generate(filePath1, filePath2, style);
//        assertEquals(expected, actual, "Something wrong LOOOOOOOOOOOL");
//    }

//    @Test
//    public void testingGenerateYamltoPlain() throws IOException {
//        System.out.println("START");
//        var expected = readFixture("DifferTestPlain.txt");//
//        var filePath1 = getFixturePath("file1TestNesting.yaml").toString();
//        var filePath2 = getFixturePath("file2TestNesting.yaml").toString();
//
//        System.out.println(expected);
//
//        var style = "plain";
//        var actual = generate(filePath1, filePath2, style);
//        assertEquals(expected, actual, "Something wrong LOOOOOOOOOOOL");
//
//    }

    @Test
    public void testingGenerateJsontoPlain() throws IOException {
        var expected = readFixture("DifferTestPlain.txt");
        var filePath1 = getFixturePath("file1TestNesting.json").toString();
        var filePath2 = getFixturePath("file2TestNesting.json").toString();

        System.out.println(expected);

        var style = "plain";
        var actual = generate(filePath1, filePath2, style);
        assertEquals(expected, actual, "Something wrong");

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
        var filePath1 = getFixturePath("file1TestNesting.yaml").toString();
        var filePath2 = getFixturePath("file2TestNesting.yaml").toString();

        System.out.println(expected);

        var style = "json";
        var actual = generate(filePath1, filePath2, style);
        assertEquals(expected, actual, "Something wrong LOOOOOOOOOOOL");

    }



}
