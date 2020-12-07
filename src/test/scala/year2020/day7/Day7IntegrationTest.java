package year2020.day7;

import org.junit.Test;
import year2020.java.day7.Day7;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class Day7IntegrationTest {

    @Test
    public void testPart1Example1() {
        List<String> lines = asList(
                "light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.",
                "dotted black bags contain no other bags."
        );
        Day7 day7 = new Day7();
        assertEquals(4, day7.part1(lines).intValue());
        assertEquals(32, day7.part2(lines).intValue());

    }

    @Test
    public void testPart2Example1() {
        List<String> lines = asList(
                "shiny gold bags contain 2 dark red bags.",
                "dark red bags contain 2 dark orange bags.",
                "dark orange bags contain 2 dark yellow bags.",
                "dark yellow bags contain 2 dark green bags.",
                "dark green bags contain 2 dark blue bags.",
                "dark blue bags contain 2 dark violet bags.",
                "dark violet bags contain no other bags."
        );
        Day7 day7 = new Day7();
        assertEquals(126, day7.part2(lines).intValue());
    }
}
