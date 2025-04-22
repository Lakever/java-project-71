package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ParseTest {

    private static Path getFixturePath(String fileName) {
        return Path.of("src/test/resources/fixtures/DifferTestDirect", fileName).toAbsolutePath().normalize();
    }

    @Test
    public void testParseJson() throws IOException {
        Path path = getFixturePath("file2Test.json");
        Map<String, Object> result = ChooseFileType.fromFile(path);

        assertEquals("hexlet.io", result.get("host"));
        assertEquals(20, result.get("timeout"));
        assertEquals(true, result.get("verbose"));
    }

    @Test
    public void testParseYaml() throws IOException {
        Path path = getFixturePath("file2Test.yaml");
        Map<String, Object> result = ChooseFileType.fromFile(path);

        assertEquals("hexlet.io", result.get("host"));
        assertEquals(20, result.get("timeout"));
        assertEquals(true, result.get("verbose"));
    }

    @Test
    public void testUnsupportedFormat() throws IOException {
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.writeString(tempFile, "just some text");

        Exception exception = assertThrows(IOException.class, () -> {
            ChooseFileType.fromFile(tempFile);
        });

        assertTrue(exception.getMessage().contains("Unsupported file format"));
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testEmptyFile() throws IOException {
        Path emptyFile = Files.createTempFile("empty", ".json");

        Files.writeString(emptyFile, "");

        Exception exception = assertThrows(IOException.class, () -> {
            ChooseFileType.fromFile(emptyFile);
        });

        assertTrue(exception.getMessage().contains("No content to map"));

        Files.deleteIfExists(emptyFile);
    }
}