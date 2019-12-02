package year2019;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import year2019.java.Day2;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class Day02Test {

    @Parameterized.Parameter()
    public Integer[] elements;
    @Parameterized.Parameter(1)
    public Integer[] result1;

    @Parameterized.Parameters
    public static Collection variations() {
        return asList(new Object[][]{
                {new Integer[]{1, 0, 0, 0, 99}, new Integer[]{2, 0, 0, 0, 99}},
                {new Integer[]{2, 3, 0, 3, 99}, new Integer[]{2, 3, 0, 6, 99}},
                {new Integer[]{2, 4, 4, 5, 99, 0}, new Integer[]{2, 4, 4, 5, 99, 9801}},
                {new Integer[]{1, 1, 1, 4, 99, 5, 6, 0, 99}, new Integer[]{30, 1, 1, 4, 2, 5, 6, 0, 99}},
                {new Integer[]{1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50}, new Integer[]{3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50}}
        });
    }

    @Test
    public void testPart1() {
        Day2 day2 = new Day2();
        List<Integer> results = asList(day2.transform(elements, 0));
        List<Integer> expectedResults = asList(result1);
        assertTrue(results.containsAll(expectedResults));
    }


}
