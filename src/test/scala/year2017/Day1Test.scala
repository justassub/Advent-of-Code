package year2017

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

class Day1Test extends FunSuite with TableDrivenPropertyChecks with Matchers {
  val valuesPart1 = Table(
    ("values", "result"),
    (Seq("1122"), 3),
    (Seq("1111"), 4),
    (Seq("1234"), 0),
    (Seq("91212129"), 9),
  )
  val valuesPart2 =
    Table(
      ("values", "result"),
      (Seq("1212"), 6),
      (Seq("1221"), 0),
      (Seq("123425"), 4),
      (Seq("123123"), 12),
      (Seq("12131415"), 4)
    )
  test("Day 1 part 1 tests ") {
    forAll(valuesPart1) {
      Day1.part1(_) shouldEqual _
    }
  }
  test("Day 1 part 2 tests ") {
    forAll(valuesPart2) {
      Day1.part2(_) shouldEqual _
    }
  }

}
