package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./src/main/resources/day2.txt"));
        correctPairs(lines);
    }

    public static void correctPairs(List<String> lines) {

        for (int i = 0; i < lines.size(); i++) {
            String[] checkThis = lines.get(i).split("");
            lines.stream().skip(i + 1).forEach(line -> {
                String[] lineArray = line.split("");
                int mistakes = 0;
                for (int possition = 0; possition < checkThis.length; possition++) {
                    if (!checkThis[possition].equals(lineArray[possition])) mistakes++;
                    if (mistakes == 2) break;
                }
                if (mistakes < 2) {
                    String secondPair = String.join("", Arrays.asList(checkThis));

                    System.out.println(Arrays.asList(lineArray).stream()
                            .filter(letter -> secondPair.contains(letter))
                            .collect(joining("")));
                }
            });
        }
    }

    public static int calculateNumber(List<String> lines) {
        int two = 0;
        int three = 0;
        for (String line : lines) {
            if (contains(line, 2)) {
                two++;
            }
            if (contains(line, 3)) {
                three++;
            }
        }
        return two * three;
    }

    private static boolean contains(String line, int manyTimes) {
        boolean contains = false;
        for (String letter : line.split("")) {
            if (line.length() - line.replace(letter, "").length() == manyTimes) {
                contains = true;
                break;
            }
        }
        return contains;
    }
}
