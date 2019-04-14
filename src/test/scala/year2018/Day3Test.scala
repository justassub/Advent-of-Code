package year2018

import org.scalatest.{FlatSpec, Matchers}
import year2018.Day3.Rectangle

class Day3Test extends FlatSpec with Matchers {
  "Regex parser" should "be correct " in {
    Day3.buildRectangleFromLine("#123 @ 3,2: 5x4").get shouldEqual Rectangle(123, 3, 2, 5, 4)
    Day3.buildRectangleFromLine("#1 @ 35,22: 555x43").get shouldEqual Rectangle(1, 35, 22, 555, 43)
  }
  "Day 3 part 1 examples" should "be equals to given answer" in {
    val exampleInput = List("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")
    Day3.part1(exampleInput) shouldBe 4
  }
  "Day 3 part 2 examples" should "be equals to given answer" in {
    val exampleInput = List("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")
    Day3.part2(exampleInput) shouldBe 3
  }
}
