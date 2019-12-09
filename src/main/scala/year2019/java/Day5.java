package year2019.java;

import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;


public class Day5 {

    public static class History {
        private int elementNumber = 0;

        public int getElementNumber() {
            return elementNumber;
        }

        public void increaseElementNumber(int howmuch) {
            elementNumber = elementNumber + howmuch;
        }
    }

    public static Scanner myInput = new Scanner(System.in);

    enum ACTION {
        ZERO {
            @Override
            public Integer[] calculate(Integer[] integers, History elementNumber) {
                return new Integer[0];
            }
        },
        ONE {
            @Override
            public Integer[] calculate(Integer[] integers, History elementNumber) {
                int number1 = integers[integers[elementNumber.getElementNumber() + 1]];
                int number2 = integers[integers[elementNumber.getElementNumber() + 2]];
                int positionToAdd = integers[elementNumber.getElementNumber() + 3];
                integers[positionToAdd] = number1 + number2;
                elementNumber.increaseElementNumber(4);
                return integers;
            }
        },
        TWO {
            @Override
            public Integer[] calculate(Integer[] integers, History elementNumber) {
                int number1 = integers[integers[elementNumber.getElementNumber() + 1]];
                int number2 = integers[integers[elementNumber.getElementNumber() + 2]];
                int positionToAdd = integers[elementNumber.getElementNumber() + 3];
                integers[positionToAdd] = number1 * number2;
                elementNumber.increaseElementNumber(4);
                return integers;
            }
        },
        THREE {
            @Override
            public Integer[] calculate(Integer[] integers, History elementNumber) {
                System.out.println("Insert next number: ");
                int input = myInput.nextInt();
                int positionToInsert = integers[elementNumber.getElementNumber() + 1];
                integers[positionToInsert] = input;
                elementNumber.increaseElementNumber(2);
                return integers;
            }
        },
        FOUR {
            @Override
            public Integer[] calculate(Integer[] integers, History elementNumber) {
                int outputPosition = integers[elementNumber.getElementNumber() + 1];
                System.out.println(integers[outputPosition]);
                elementNumber.increaseElementNumber(2);
                return integers;
            }
        };

        public abstract Integer[] calculate(Integer[] integers, History elementNumber);

        public static ACTION getEnum(Integer integer) {
            switch (integer) {
                case 1:
                    return ACTION.ONE;
                case 2:
                    return ACTION.TWO;
                case 3:
                    return ACTION.THREE;
                case 4:
                    return ACTION.FOUR;
                default:
                    return null;
            }
        }
    }


    public Integer[] transform(Integer[] integers, History history) {
        int nextElementPosition = history.getElementNumber();
        int nextAction = integers[nextElementPosition];
        if (nextAction == 99) {
            return integers;
        }
        integers = ACTION.getEnum(nextAction).calculate(integers, history);
        return transform(integers, history);
    }

    protected Integer part1(List<Integer> input) {
        Integer[] integers = input.toArray(new Integer[0]);
        return transform(integers, new History())[0];
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        // List<Integer> integers = day5.getFileContentSplited(",").stream().map(Integer::parseInt).collect(Collectors.toList());
        day5.part1(asList(3, 0, 4, 0, 99));
    }
}
