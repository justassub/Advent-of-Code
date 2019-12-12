package year2019

import org.scalatest.{FlatSpec, Matchers}
import year2019.scala.Day6

class Day6Test extends FlatSpec with Matchers {
  "Day 6 part 1 example" should "be equals to given answer" in {
    val testData = Seq("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L)")
    Day6.part1(testData) shouldEqual 42
  }

}
