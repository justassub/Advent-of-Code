package year2015

import org.scalatest.{FlatSpec, Matchers}

class Day3Test extends FlatSpec with Matchers {
  "Day 3 part 1" should "be equals to given examples" in {
    Day03.part1(Seq(">")) shouldEqual 2
    Day03.part1(Seq("^>v<")) shouldEqual 4
    Day03.part1(Seq("^v^v^v^v^v")) shouldEqual 2
  }
  "Day 3 part 2" should "be equals to given examples" in {
    Day03.part2(Seq("^v")) shouldEqual 3
    Day03.part2(Seq("^>v<")) shouldEqual 3
    Day03.part2(Seq("^v^v^v^v^v")) shouldEqual 11
  }
}
