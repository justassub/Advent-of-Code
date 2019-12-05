package year2019

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}
import year2019.scala.Day4

class Day4Test extends FunSuite with Matchers with TableDrivenPropertyChecks {
  val valuesPart1 =
    Table(
      ("values", "result"),
      ("111111", true),
      ("223450", false),
      ("123789", false)
    )
  val valuesPart2 =
    Table(
      ("values", "result"),
      ("112233", true),
      ("123444", false),
      ("111122", true)
    )

  test("Day 3") {
    forAll(valuesPart1) {
      Day4.isPasswordOne(_) shouldEqual _
    }
    forAll(valuesPart2) {
      Day4.isPasswordTwo(_) shouldEqual _
    }
  }
}
