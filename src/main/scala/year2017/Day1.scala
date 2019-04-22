package year2017


object Day1 extends Main2017[String, Int, Int] {
  println(part1(seqString))
  println(part2(seqString))

  override def part1(seq: Seq[String]) = {
    val numbers = Day1Util.textToInt(seq.head)
    val shiftedNumbers = Day1Util.moveDigitsAround(numbers)
    Day1Util.sameIndexElements(numbers, shiftedNumbers).sum
  }

  override def part2(seq: Seq[String]) = {
    val numbers = Day1Util.textToInt(seq.head)
    val shiftedNumbers = Day1Util.moveDigitsAround(numbers)(numbers.size / 2)
    Day1Util.sameIndexElements(numbers, shiftedNumbers).sum
  }
}

object Day1Util {
  def textToInt(text: String): Seq[Int] = text.map(_.asDigit)

  def moveDigitsAround(seq: Seq[Int])(implicit n: Int = 1) = {
    val count = seq.size - n
    seq.drop(count) ++ seq.take(count)
  }

  def sameIndexElements(seq1: Seq[Int], seq2: Seq[Int]) =
    (seq1 zip seq2)
      .filter(pair => pair._1 == pair._2)
      .map(_._1)
      .toList
}