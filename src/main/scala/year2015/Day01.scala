package year2015

object Day01 extends Main2015[String, Int, Int] {
  println(part1(seqString))
  println(part2(seqString))

  override def part1(seq: Seq[String]) = {
    val text = seq.head
    text.foldLeft(0)(_ + pointByFloor(_))
  }

  override def part2(seq: Seq[String]) = {
    val text = seq.head
    text.scanLeft(0)((result, floorMark) => result + pointByFloor(floorMark))
      .zipWithIndex
      .find(_._1 == -1)
      .get
      ._2
  }

  private def pointByFloor(floorMark: Char) = floorMark match {
    case '(' => 1
    case ')' => -1
    case _ => 0
  }
}
