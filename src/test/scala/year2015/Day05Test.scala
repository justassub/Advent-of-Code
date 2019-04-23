package year2015

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

class Day05Test extends FunSuite with TableDrivenPropertyChecks with Matchers {
  val valuesPart1 = Table(
    ("values", "result"),
    (Seq("ugknbfddgicrmopn"), 1),
    (Seq("aaa"), 1),
    (Seq("jchzalrnumimnmhp"), 0),
    (Seq("haegwjzuvuyypxyu"), 0),
    (Seq("haegwjzuvuyypxyu", "dvszwmarrgswjxmb", "ugknbfddgicrmopn"), 1))

  test("Day 4 part 1 tests ") {
    forAll(valuesPart1) {
      Day05.part1(_) shouldEqual _
    }
  }
}
