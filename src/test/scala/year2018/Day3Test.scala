package year2018

import org.scalatest.{FlatSpec, Matchers}

class Day3Test extends FlatSpec with Matchers {
  "Day 3 part 1 examples" should "be equals to given answer" in {
    val exampleInput = List("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")
    Day3.part1(exampleInput) shouldBe  4
  }

}
