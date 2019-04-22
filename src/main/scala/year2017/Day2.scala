package year2017

object Day2 extends Main2017[String, Int, Int] {
  println(part1(seqString))
  println(part2(seqString))

  override def part1(seq: Seq[String]) = {
    seq.map(Day2Util.splitLine).map(list => list.max - list.min).sum
  }

  override def part2(seq: Seq[String]) = {
    seq.map(Day2Util.splitLine).flatMap(Day2Util.findEvenPairs).sum
  }
}

private object Day2Util {
  def splitLine(line: String) = line.split("\\s+").map(_.toInt).toList

  def findEvenPairs(seq: Seq[Int]) = {
    for {
      n1 <- seq
      n2 <- seq if (n1 > n2) && n1 % n2 == 0
    } yield n1 / n2
  }
}