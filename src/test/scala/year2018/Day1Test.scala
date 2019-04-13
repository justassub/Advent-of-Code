package year2018

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

class Day1Test extends FunSuite with Matchers with TableDrivenPropertyChecks {
  val valuesPart1 =
    Table(
      ("values", "result"),
      (Seq(1, -2, 3, 1), 3),
      (Seq(1, 1, 1), 3),
      (Seq(1, 1, -2), 0),
      (Seq(-1, -2, -3), -6),
    )
  val valuesPart2 =
    Table(
      ("values", "result"),
      (Seq(1, -1), 0),
      (Seq(3, 3, 4, -2, -4), 10),
      (Seq(-6, 3, 8, 5, -6), 5),
      (Seq(7, 7, -2, -7, -4), 14),
    )
  test("Day 1 part 1") {
    forAll(valuesPart1) {
      Day1.part1(_) shouldEqual _
    }
  }

  test("Day 1 part 2") {
    forAll(valuesPart2) {
      Day1.part2(_) shouldEqual _
    }
  }

}
