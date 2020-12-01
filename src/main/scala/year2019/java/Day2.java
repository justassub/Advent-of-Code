package year2019.java;

import java.util.List;
import java.util.stream.Collectors;

public class Day2 extends Main2019<List<Integer>, List<Integer>, Integer, Integer> {
    public static class NotSupportedOperation extends RuntimeException {
    }

    private int calculate(Integer action, Integer number1, Integer number2) {
        switch (action) {
            case 1:
                return number1 + number2;
            case 2:
                return number1 * number2;
            default:
                throw new NotSupportedOperation();
        }
    }

    public Integer[] transform(Integer[] integers, Integer elementNumber) {
        if (integers[elementNumber] == 99) {
            return integers;
        }
        int number1 = integers[integers[elementNumber + 1]];
        int number2 = integers[integers[elementNumber + 2]];
        int positionToAdd = integers[elementNumber + 3];
        Integer numberToAdd = calculate(integers[elementNumber], number1, number2);
        integers[positionToAdd] = numberToAdd;
        return transform(integers, elementNumber + 4);

    }

    @Override
    protected Integer part1(List<Integer> input) {
        Integer[] integers = input.stream().toArray(Integer[]::new);
        integers[1] = 12;
        integers[2] = 2;
        return transform(integers, 0)[0];
    }

    @Override
    protected Integer part2(List<Integer> input) {
        int target = 19690720;
        int result = 0;
        for (int i = 1; i < 100; i++) {
            if (result != 0) {
                break;
            }
            for (int k = 1; k < 100; k++) {
                Integer[] integers = input.toArray(new Integer[0]);
                integers[1] = i;
                integers[2] = k;
                if (transform(integers, 0)[0] == target) {
                    result = 100 * i + k;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Day2 day2 = new Day2();
        List<Integer> integers = day2.getFileContentSplited(",").stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(day2.part1(integers));
        System.out.println(day2.part2(integers));
    }
}
