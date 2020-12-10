import org.junit.Test;
import lt.justassub.adventofcode.year2020.Day2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Day2Test {
    @Test
    public void checkIfPasswordIsCorrectOld1() {
        assertTrue(Day2.passwordCheck("1-3 a: abcde",true));
    }

    @Test
    public void checkIfPasswordIsCorrectOld2() {
        assertFalse(Day2.passwordCheck("1-3 b: cdefg",true));
    }

    @Test
    public void checkIfPasswordIsCorrectOld3() {
        assertTrue(Day2.passwordCheck("2-9 c: ccccccccc",true));
    }
    @Test
    public void checkIfPasswordIsCorrectNew1() {
        assertTrue(Day2.passwordCheck("1-3 a: abcde",false));
    }

    @Test
    public void checkIfPasswordIsCorrectNew2() {
        assertFalse(Day2.passwordCheck("1-3 b: cdefg",false));
    }

    @Test
    public void checkIfPasswordIsCorrectNew3() {
        assertFalse(Day2.passwordCheck("2-9 c: ccccccccc",false));
    }
}
