import org.junit.Assert;
import org.junit.Test;
import lt.justassub.adventofcode.year2020.Day9;

import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Day9Test {
    @Test
    public void part1Example1() {
        List<Long> values = LongStream.rangeClosed(1, 25).boxed().collect(toList());
        values.add(26L);
        values.add(65L);
        Map.Entry<Integer, Long> result = new Day9().returnIndexThatDoesNotFollow(values, 25);
        Assert.assertEquals(65L, result.getValue().longValue());
        Assert.assertEquals(26, result.getKey().intValue());
    }

    @Test
    public void part1Example2() {
        List<Long> values = Stream.of(
                35,
                20,
                15,
                25,
                47,
                40,
                62,
                55,
                65,
                95,
                102,
                117,
                150,
                182,
                127,
                219,
                299,
                277,
                309,
                576
        ).map(Long::valueOf).collect(toList());


        Map.Entry<Integer, Long> result = new Day9().returnIndexThatDoesNotFollow(values, 5);
        Assert.assertEquals(127, result.getValue().longValue());
        Assert.assertEquals(14, result.getKey().intValue());
    }

    @Test
    public void part2Example1() {
        List<Long> values = Stream.of(
                35,
                20,
                15,
                25,
                47,
                40,
                62,
                55,
                65,
                95,
                102,
                117,
                150,
                182,
                127,
                219,
                299,
                277,
                309,
                576
        ).map(Long::valueOf).collect(toList());


        Long result = new Day9().findPreambleNumbersThatHasSum(values, 5);

        Assert.assertEquals(62L, result.longValue());
    }


}
