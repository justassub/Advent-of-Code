package year2018

import org.scalatest.{FlatSpec, Matchers}
import util.FileReader

class Day4Test extends FlatSpec with Matchers{
  "Day 4 example part 1" should "be correct with given answer" in {
    val seq = FileReader.readResource("src/test/scala/resources/day4.txt")
    Day4.part1(seq) should be equals 240
  }
  "Day 4 example part 2" should "be correct with given answer" in {
    val seq = FileReader.readResource("src/test/scala/resources/day4.txt")
    Day4.part2(seq) should be equals 4455
  }
}
