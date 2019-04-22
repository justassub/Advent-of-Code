package year2015

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

class Day1Test extends FunSuite with TableDrivenPropertyChecks with Matchers {
  val valuesPart1 = Table(
    ("values", "result"),
    (Seq("(())"), 0),
    (Seq("()()"), 0),
    (Seq("((("), 3),
    (Seq("(()(()("), 3),
    (Seq("))((((("), 3),
    (Seq("())"), -1),
    (Seq("))("), -1),
    (Seq(")))"), -3),
    (Seq(")())())"), -3))

  val valuesPart2 = Table(
    ("values", "result"),
    (Seq(")"), 1),
    (Seq("()())"), 5))


  test("Day 1 part 1 tests ") {
    forAll(valuesPart1) {
      Day01.part1(_) shouldEqual _
    }
  }
  test("Day 1 part 2 tests ") {
    forAll(valuesPart2) {
      Day01.part2(_) shouldEqual _
    }
  }
}
