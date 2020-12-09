package year2020.java;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Day9 extends Main2020<List<Long>, List<Long>, Map.Entry<Integer, Long>, Long> {
    @Override
    protected Map.Entry<Integer, Long> part1(List<Long> input) {
        return returnIndexThatDoesNotFollow(input, 25);
    }

    public Map.Entry<Integer, Long> returnIndexThatDoesNotFollow(List<Long> allNumbers, int preambleNumbers) {
        for (int i = 0; i < allNumbers.size() - preambleNumbers; i++) {
            List<Long> sublist = allNumbers.subList(i, i + preambleNumbers);

            Long numberToCheck = allNumbers.get(i + preambleNumbers);
            if (!checkIfPossibleSumInArray(sublist, numberToCheck)) {
                return Map.entry(i + preambleNumbers, numberToCheck);
            }

        }
        throw new RuntimeException("All numbers follow good pattern");
    }

    private boolean checkIfPossibleSumInArray(List<Long> array, long numberToCheck) {

        for (int i = 0; i < array.size() - 1; i++) {
            for (int k = i + 1; k < array.size(); k++) {
                if (array.get(i) + array.get(k) == numberToCheck) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected Long part2(List<Long> input) {
        return null;
    }

    public static void main(String[] args) {
        Day9 day9 = new Day9();
        List<Long> integers = day9.getFileContent().map(Long::parseLong).collect(toList());
        System.out.println(day9.part1(integers));
    }
}
