package year2015

import org.scalatest.{FlatSpec, Matchers}

class Day06Test extends FlatSpec with Matchers {
  "Day 06 part 1" should "be equals to given examples" in {
    val exampleSeq = Seq("turn on 0,0 through 999,999", "toggle 0,0 through 999,0", "turn off 499,499 through 500,500")
    Day06.part1(exampleSeq) shouldEqual 997997
  }
}
