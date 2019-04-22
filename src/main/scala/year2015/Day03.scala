package year2015

case class History(x: Int, y: Int)

object Day03 extends Main2015[String, Int, Int] {
  println(part1(seqString))
  println(part2(seqString))

  override def part1(seq: Seq[String]) = {
    seq
      .head
      .toCharArray
      .scanLeft(History(0, 0))(Day03Util.changeHistory)
      .distinct
      .size
  }


  override def part2(seq: Seq[String]) = {
    val (santaRoute, robotRoute) = seq.head.toCharArray.zipWithIndex.partition(_._2 % 2 == 0)
    val santaHouses = santaRoute.map(_._1).scanLeft(History(0, 0))(Day03Util.changeHistory).distinct.toList
    val robotHouses = robotRoute.map(_._1).scanLeft(History(0, 0))(Day03Util.changeHistory).distinct.toList
    (santaHouses ::: robotHouses).distinct.size
  }
}

object Day03Util {
  def changeHistory(history: History, direction: Char) = direction match {
    case '^' => history.copy(y = history.y + 1)
    case 'v' => history.copy(y = history.y - 1)
    case '>' => history.copy(x = history.x + 1)
    case '<' => history.copy(x = history.x - 1)
    case _ => history
  }
}