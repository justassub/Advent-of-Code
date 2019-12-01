package year2019;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.format;

public abstract class Main2019<I, O1, O2> {

    protected final String getPackage() {
        return "2019";
    }

    protected final String getFileName() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    protected final Stream<String> getFileContent() {
        try {
            return Files.lines(Paths.get(format("src/main/resources/%s/%s.txt", getPackage(), getFileName())));
        } catch (IOException e) {
            throw new RuntimeException("File was not found", e);
        }
    }

    protected abstract O1 part1(List<I> input);

    protected abstract O2 part2(List<I> input);
}
