package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true, // Включаем стандартные help/version
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {

    @Option(names = {"-f", "--format"},
            description = "Output format (default: ${DEFAULT-VALUE})",
            defaultValue = "stylish")
    private String format; // Теперь это String, а не boolean!

    @Parameters(index = "0", description = "Path to first file")
    private String filePath1;

    @Parameters(index = "1", description = "Path to second file")
    private String filePath2;

    @Override
    public void run() {
        System.out.println("Comparing files...");
        System.out.println("Format: " + format);
        System.out.println("File1: " + filePath1);
        System.out.println("File2: " + filePath2);

        // Реальная логика:
        // String diff = Differ.generate(filePath1, filePath2, format);
        // System.out.println(diff);
    }

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}