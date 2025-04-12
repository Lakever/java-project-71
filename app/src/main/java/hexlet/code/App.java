package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.Map;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {

    @Option(names = {"-f", "--format"},
            description = "Output format (default: ${DEFAULT-VALUE})",
            defaultValue = "stylish")
    private String format;

    @Parameters(index = "0", description = "Path to first file")
    private String filePath1;

    @Parameters(index = "1", description = "Path to second file")
    private String filePath2;

    @Override
    public void run() {
        try {
            System.out.println("Comparing files...");
            System.out.println("Format: " + format);
            System.out.println("File1: " + filePath1);
            System.out.println("File2: " + filePath2);

            Map<String, Object> data1 = Parser.pars(filePath1);
            Map<String, Object> data2 = Parser.pars(filePath2);

            System.out.println("\nFile 1 content:");
            data1.forEach((key, value) -> System.out.println(key + " = " + value));

            System.out.println("\nFile 2 content:");
            data2.forEach((key, value) -> System.out.println(key + " = " + value));

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}