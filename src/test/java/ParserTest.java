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
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath()
                .normalize();
    }

    @Test
    public void testParseValidJson() throws IOException {
        // 1. Подготовка тестовых данных
        String testFileName = "file2Test.json";
        Path testFilePath = getFixturePath(testFileName);

        // 2. Проверка существования тестового файла
        assertTrue(Files.exists(testFilePath),
                "Test file '" + testFileName + "' not found at: " + testFilePath);

        // 3. Ожидаемый результат
        Map<String, Object> expected = Map.of(
                "host", "hexlet.io",
                "timeout", 20,
                "verbose", true
        );

        // 4. Вызов тестируемого метода
        Map<String, Object> actual = pars(testFilePath.toString());

        // 5. Проверка результата
        assertEquals(expected, actual,
                "Error");

        System.out.println("Test passed successfully for file: " + testFileName);
    }


}