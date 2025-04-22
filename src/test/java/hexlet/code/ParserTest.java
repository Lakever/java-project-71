package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.Parser.pars;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class ParserTest {

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", "DifferTestDirect", fileName)
                .toAbsolutePath()
                .normalize();
    }

    @Test
    public void testParseValidJson() throws IOException {
        String testFileName = "file2Test.json";
        Path testFilePath = getFixturePath(testFileName);

        assertTrue(Files.exists(testFilePath));

        Map<String, Object> expected = Map.of(
                "host", "hexlet.io",
                "timeout", 20,
                "verbose", true
        );

        Map<String, Object> actual = Parser.pars(testFilePath.toString());

        assertEquals(expected, actual);
    }

    @Test
    public void testParseValidYaml() throws IOException {
        String testFileName = "file2Test.json";
        Path testFilePath = getFixturePath(testFileName);

        assertTrue(Files.exists(testFilePath));

        Map<String, Object> expected = Map.of(
                "host", "hexlet.io",
                "timeout", 20,
                "verbose", true
        );

        Map<String, Object> actual = Parser.pars(testFilePath.toString());

        assertEquals(expected, actual);
    }
}
