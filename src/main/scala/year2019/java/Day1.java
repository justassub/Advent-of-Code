package year2019.java;

import java.util.List;
import java.util.stream.Collectors;

public class Day1 extends Main2019<Integer, Integer, Integer> {

    @Override
    public Integer part1(List<Integer> integers) {
        return integers.stream()
                .mapToInt(this::calculate)
                .sum();
    }

    private Integer calculate(Integer i) {
        return (i / 3) - 2;
    }

    @Override
    public Integer part2(List<Integer> integers) {
        return integers.stream()
                .mapToInt(n -> calculate2(n, 0))
                .sum();
    }

    private Integer calculate2(Integer fuel, Integer sum) {
        int fuel_left = calculate(fuel);
        if (fuel_left <= 0) {
            return sum;
        }
        return calculate2(fuel_left, sum + fuel_left);
    }

    public static void main(String[] args) {
        Day1 day01 = new Day1();
        List<Integer> integers = day01.getFileContent().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(day01.part1(integers));
        System.out.println(day01.part2(integers));
    }
}
