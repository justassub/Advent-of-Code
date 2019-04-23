package year2015

object Day05 extends Main2015[String, Int, Int] {
  println(part1(seqString))

  override def part1(seq: Seq[String]) = seq.filter(isNice).size

  private def isNice(line: String) = {
    !containsForbiddenLetters(line) && containsGivenChars(line) > 2 && containsDoubleLetters(line) > 0
  }

  private def containsForbiddenLetters(string: String) = List("ab", "cd", "pq", "xy").exists(string.contains)

  private def containsGivenChars(string: String) = {
    val allowedVowels = "aeiou"
    string.filter(allowedVowels.contains(_)).size
  }

  private def containsDoubleLetters(string: String) = {
    string zip string.drop(1) filter (pair => pair._1 == pair._2) size
  }

  override def part2(strings: Seq[String]): Int = ???


}
