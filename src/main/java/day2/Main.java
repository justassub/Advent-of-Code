package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./src/main/resources/day3.txt"));
        System.out.println(calculateNumber(lines));
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
