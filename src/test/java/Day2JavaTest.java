import day2.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Day2JavaTest {
    @Test
    public void testLetters() {
        Assert.assertEquals(12, Main.calculateNumber(
                Arrays.asList(
                        "abcdef",
                        "bababc",
                        "abbcde",
                        "abcccd",
                        "aabcdd",
                        "abcdee",
                        "ababab")));

    }
}
