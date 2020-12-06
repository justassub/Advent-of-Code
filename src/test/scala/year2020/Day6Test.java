package year2020;

import org.junit.Test;
import year2020.java.Day6;

import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;


public class Day6Test {
    private Day6 day6 = new Day6();

    @Test
    public void returnsOnePersonUniqueAnswers() {
        Set<String> uniqueAnswers = day6.getGroupDistinctAnswers(Set.of("abcc"));
        assertEquals(3, uniqueAnswers.size());
    }

    @Test
    public void returnsTwoPersonUniqueAnswers() {
        Set<String> uniqueAnswers = day6.getGroupDistinctAnswers(Set.of("abcc", "dff"));
        assertEquals(5, uniqueAnswers.size());
    }

    @Test
    public void returnsTwoPersonTreeUniqueAnswersSameAnswers() {
        Set<String> uniqueAnswers = day6.getGroupDistinctAnswers(Set.of("abcc", "dff", "a", "f", "af"));
        assertEquals(5, uniqueAnswers.size());
    }

    @Test
    public void exampleMultipleSameGroup() {
        List<String> answers = asList("abcx", "abcy", "abcz");
        int uniqueAnswers = day6.part1(answers);
        assertEquals(6, uniqueAnswers);
    }

    @Test
    public void exampleMultipleGroups() {
        List<String> answers = asList(
                "abc",
                "a",
                "b",
                "c",
                "\n",
                "ab",
                "ac",
                "\n",
                "a",
                "a",
                "a",
                "a",
                "\n",
                "b");
        int uniqueAnswers = day6.part1(answers);
        assertEquals(11, uniqueAnswers);
    }

    @Test
    public void returnSameAnswerGroup() {
        Set<String> sameAnswers = day6.getGroupSameAnswers(Set.of("abc"));
        assertEquals(3, sameAnswers.size());
    }

    @Test
    public void returnSameAnswerGroupTwo() {
        Set<String> sameAnswers = day6.getGroupSameAnswers(Set.of("abc", "ab"));
        assertEquals(2, sameAnswers.size());
    }

}
