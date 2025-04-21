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
        return Paths.get("src", "test", "resources",  "fixtures", "DifferTestDirect", fileName)
                .toAbsolutePath()
                .normalize();
    }


    private static String readFixture(String fileName) throws IOException {
        var result = Files.readString(getFixturePath(fileName));
        return result.trim();
    }
    @Test
    public void testingGenerate() throws IOException {
        System.out.println("START");
//        var filePath = getFixturePath("DefferTest.txt"); // получили путь
        var expected = readFixture("DifferTest.txt");
        var filePath1 = getFixturePath("file1.json").toString();
        var filePath2 = getFixturePath("file2.json").toString();

        System.out.println(expected);
        var actual = generate(filePath1, filePath2);
        assertEquals(expected, actual, "Something wrong LOOOOOOOOOOOL");
    }
}
