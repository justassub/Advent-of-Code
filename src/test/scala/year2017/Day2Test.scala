package year2017

import org.scalatest.{FlatSpec, Matchers}

class Day2Test extends FlatSpec with Matchers {
  "Day 2 part 1 example" should "be equals to given answer" in {
    val testData = Seq("5 1 9 5", "7 5 3", "2 4 6 8")
    Day2.part1(testData) shouldEqual 18
  }
  "Day 2 part 2 example" should "be equals to given answer" in {
    val testData = Seq("5 9 2 8", "9 4 7 3", "3 8 6 5")
    Day2.part2(testData) shouldEqual 9
  }
}
