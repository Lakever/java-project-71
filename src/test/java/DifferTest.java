import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
import static hexlet.code.Parser.pars;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class DifferTest {

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
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
        System.out.println(expected);
        var actual = generate("file1.json", "file2.json");
        assertEquals(expected, actual, "Something wrong");
    }
}
