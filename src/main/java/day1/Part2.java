package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = Files.readAllLines(Paths.get("./src/main/resources/day1-2.txt"))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        LinkedList<Integer> sums = calculateSums(numbers);
        System.out.println(findDuplicate(sums, numbers));

    }

    private static LinkedList<Integer> calculateSums(List<Integer> numbers) {
        LinkedList<Integer> sums = new LinkedList<>();
        sums.add(0);
        numbers.forEach(number -> sums.add(sums.getLast() + number));
        return sums;
    }

    private static int findDuplicate(LinkedList<Integer> sums, List<Integer> numbers) {
        Integer dublicate = null;
        for (Integer number : numbers) {
            if (sums.contains(sums.getLast() + number)) {
                dublicate = sums.getLast() + number;
                break;
            }
            sums.add(sums.getLast() + number);
        }
        if (dublicate == null) {
            return findDuplicate(sums, numbers);
        } else return dublicate;
    }

}
