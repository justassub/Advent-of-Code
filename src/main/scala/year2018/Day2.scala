package year2018

object Day2 extends Main2018[String, Int, String] {

  println(part1(seqString))
  println(part2(seqString))

  def part1(seq: Seq[String]): Int = seq.count(hasCount(2)) * seq.count(hasCount(3))

  private def hasCount(count: Int)(letters: String) = letterCounts(letters).values.toSet.contains(count)

  private def letterCounts(letters: String) =
    letters
      .groupBy(identity) // (abcba will be Map(a => aa, b => bb, c => c)
      .mapValues(_.length)

  def part2(seq: Seq[String]): String = {
    createPairs(seq.toList)
      .find(pair => differenceBetweenLetters(pair._1, pair._2) == 1)
      .map(pair => commonLetters(pair._1, pair._2))
      .getOrElse("NOTHING")
  }

  private def createPairs(leftSeq: Seq[String]): Stream[(String, String)] = {
    leftSeq match {
      case x :: seq => allPairs(x, seq) ++ createPairs(seq)
      case _ => Stream[(String, String)]()
    }
  }

  private def allPairs(box: String, seq: Seq[String]) =
    (for (name <- seq) yield (box, name)).toStream

  private def differenceBetweenLetters(string1: String, string2: String) =
    string1 zip string2 count (pair => pair._1 != pair._2)

  private def commonLetters(string1: String, string2: String) =
    string1 zip string2 filter (pair => pair._1 == pair._2) map (_._1) mkString

}
