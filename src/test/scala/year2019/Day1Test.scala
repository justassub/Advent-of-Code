package year2019

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}
import year2019.scala.Day1

class Day1Test extends FunSuite with Matchers with TableDrivenPropertyChecks {
  val valuesPart2 =
    Table(
      ("values", "result"),
      (Seq(14), 2),
      (Seq(1969), 966),
      (Seq(100756), 50346),
      (Seq(100756, 14, 1969), 2 + 966 + 50346),
      (Seq(100756, 1969), 966 + 50346)

    )

  test("Day 1 part 2") {
    forAll(valuesPart2) {
      Day1.part2(_) shouldEqual _
    }
  }
}
