package year2015

import org.scalatest.{FlatSpec, Matchers}

class Day2Test extends FlatSpec with Matchers {
  "Day 2 part 1" should "be equals to given examples" in {
    Day02.part1(Seq("2x3x4")) shouldEqual 58
    Day02.part1(Seq("1x1x10")) shouldEqual 43
    Day02.part1(Seq("2x3x4", "1x1x10")) shouldEqual 58 + 43
  }
  "Day 2 part 2" should "be equals to given examples" in {
    Day02.part2(Seq("2x3x4")) shouldEqual 34
    Day02.part2(Seq("1x1x10")) shouldEqual 14
    Day02.part2(Seq("2x3x4", "1x1x10")) shouldEqual 34 + 14
  }
}
