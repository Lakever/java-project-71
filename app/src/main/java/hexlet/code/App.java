package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Option(names = {"-f", "--format"},
            description = "Output format (default: ${DEFAULT-VALUE})",
            defaultValue = "stylish")
    private String format;

    @Parameters(index = "0", description = "Path to first file")
    private String filePath1;

    @Parameters(index = "1", description = "Path to second file")
    private String filePath2;

    @Override
    public Integer call() {  // Заменяем run() на call()
        try {
            String diff = Differ.generate(filePath1, filePath2, format);
            System.out.println(diff);
            return 0;  // Возвращаем 0 при успехе
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return 1;  //  1 при ошибке
        }
    }


    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
