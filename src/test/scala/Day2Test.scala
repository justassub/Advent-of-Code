import day2.Day2
import org.scalatest.{FunSuite, Matchers}

class Day2Test extends FunSuite with Matchers {
  test("sum should be 10"){
    Day2.calculatesFirstDuplicatedSum(Seq(3,3,4,-2,-4),Day2.returnSums(Seq(3,3,4,-2,-4))) shouldEqual 10
  }
  test("sum should be 5"){
    Day2.calculatesFirstDuplicatedSum(Seq(-6,3,8,5,-6),Day2.returnSums(Seq(-6,3,8,5,-6))) shouldEqual 5
  }
  test("sum should be 14"){
    Day2.calculatesFirstDuplicatedSum(Seq(7,7,-2,-7,-4),Day2.returnSums(Seq(7,7,-2,-7,-4))) shouldEqual 14
  }
}
