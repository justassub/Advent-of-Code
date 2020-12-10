import org.junit.Assert;
import org.junit.Test;
import lt.justassub.adventofcode.year2020.Day1;

import java.util.List;

import static java.util.Arrays.asList;

public class Day1Test {
    @Test
    public void dayFirstShouldReturnExampleAnswer1() {
        Day1 day1 = new Day1();
        List<Integer> givenNumbers = asList(1721, 979, 366, 299, 675, 1456);
        Assert.assertEquals(514579, day1.part1(givenNumbers).intValue());
    }

    @Test
    public void dayFirstShouldReturnExampleAnswer2() {
        Day1 day1 = new Day1();
        List<Integer> givenNumbers = asList(1721, 979, 366, 299, 675, 1456);
        Assert.assertEquals(241861950, day1.part2(givenNumbers).intValue());
    }
}
