package year2019.scala


object Day4 extends Main2019[Int, Int, Int] {
  val part1Regex = "^(?=[0-9]{6}$)(?=.*([0-9])\\1)(?:0|1(?!0)|2(?![01])|3(?![0-2])|4(?![0-3])|5(?![0-4])|6(?![0-5])|7(?![0-6])|8(?![0-7])|9(?![0-8]))+$"
  val part2Regex = "^(?=[0-9]{6}$)(?=(?:.*([0-9])(?!\\1))?([0-9])\\2(?!\\2))(?:0|1(?!0)|2(?![01])|3(?![0-2])|4(?![0-3])|5(?![0-4])|6(?![0-5])|7(?![0-6])|8(?![0-7])|9(?![0-8]))+$"
  val part3Regex = "(.)(?<!\1\1)\1(?!\1)"

  //TODO add tests
  override def part1(seq: Seq[Int]) = {
    seq.count(isPassword)
  }

  def isPassword(number: Int): Boolean = {
    containsAdjanced(number.toString) && notIncreases(number.toString)
  }

  def containsAdjanced(password: String) = password.sliding(2).count(p => p(0) == p(1)) > 0

  def notIncreases(password: String) = password.toCharArray.map(_.asDigit).sorted.mkString == password

  //TODO add tests
  override def part2(seq: Seq[Int]) = {
    //Finds numbers that are repeated only one. //TODO refactor with function programming
    def adjTwice(n: Int) = {
      val countAdj = new Array[Int](10)
      var last = 10
      var reasNumber = n
      while (reasNumber > 0) {
        val digit = reasNumber % 10
        if (digit == last) {
          countAdj(digit) = countAdj(digit) + 1
        }
        reasNumber = reasNumber / 10
        last = digit
      }
      countAdj.contains(1)
    }
    seq.count(p => adjTwice(p) && isPassword(p))

  }

  def isPassword1Regex(int: Int) = int.toString.matches(part1Regex)

  def isPassword2Regex(int: Int) = int.toString.matches(part2Regex)


  println(part1(367479 to 893698))
  println(part2(367479 to 893698))
}
