package year2019;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import year2019.java.Day1;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Day01Test {

    @Parameterized.Parameter()
    public Integer fuel;
    @Parameterized.Parameter(1)
    public Integer result1;
    @Parameterized.Parameter(2)
    public Integer result2;

    @Parameterized.Parameters
    public static Collection variations() {
        return asList(new Object[][]{
                {12, 2, 2},
                {14, 2, 2},
                {1969, 654, 966},
                {100756, 33583, 50346}

        });
    }

    @Test
    public void testPart1() {
        Day1 day1 = new Day1();
        assertEquals(day1.part1(asList(fuel)), result1);
        assertEquals(day1.part2(asList(fuel)), result2);
    }


}