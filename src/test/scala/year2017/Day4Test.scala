package year2017

import org.scalatest.{FlatSpec, Matchers}

class Day4Test extends FlatSpec with Matchers {
  "Day 2 part 1 example" should "be equals to given answer" in {
    val passwords = Seq("aa bb cc dd ee", "aa bb cc dd aa", "aa bb cc dd aaa")
    Day4.part1(passwords) shouldEqual 2
  }
  "Day 2 part 2 example" should "be equals to given answer" in {
    val passwords = Seq("abcde fghij", "abcde xyz ecdab", "a ab abc abd abf abj", "iiii oiii ooii oooi oooo", "oiii ioii iioi iiio")
    Day4.part2(passwords) shouldEqual 3
  }
}
