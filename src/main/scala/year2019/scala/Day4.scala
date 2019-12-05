package year2019.scala

object Day4 extends Main2019[Int, Int, Int] {
  val part1Regex = "^(?=[0-9]{6}$)(?=.*([0-9])\\1)(?:0|1(?!0)|2(?![01])|3(?![0-2])|4(?![0-3])|5(?![0-4])|6(?![0-5])|7(?![0-6])|8(?![0-7])|9(?![0-8]))+$"
  val part2Regex = "^(?=[0-9]{6}$)(?=(?:.*([0-9])(?!\\1))?([0-9])\\2(?!\\2))(?:0|1(?!0)|2(?![01])|3(?![0-2])|4(?![0-3])|5(?![0-4])|6(?![0-5])|7(?![0-6])|8(?![0-7])|9(?![0-8]))+$"

  override def part1(seq: Seq[Int]) = {
    seq.count(n => isPasswordOne(n.toString))
  }

  override def part2(seq: Seq[Int]) = seq.count(n => isPasswordTwo(n.toString))

  def isPasswordOne(number: String): Boolean = {
    containsAdjanced(number) && notIncreases(number)
  }

  def isPasswordTwo(number: String): Boolean = {
    containsAdjanced(number) && notIncreases(number) && containsAdjancedTwo(number)
  }

  def containsAdjancedTwo(number: String) = number.toCharArray.groupBy(identity).exists({
    case (_, b) => b.length == 2
  })

  def containsAdjanced(password: String) = password.sliding(2).count(p => p(0) == p(1)) > 0

  def notIncreases(password: String) = password.toCharArray.map(_.asDigit).sorted.mkString == password


  def isPassword1Regex(number: String) = number.matches(part1Regex)

  def isPassword2Regex(number: String) = number.matches(part2Regex)

  println(part1(367479 to 893698))
  println(part2(367479 to 893698))
}
