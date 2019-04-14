package year2018

import scala.collection.mutable

object Day3 extends Main[String, Int, Int] {
  println(part1(seqString))
  println(part2(seqString))

  case class Rectangle(id: Int, left: Int, top: Int, width: Int, height: Int)

  def buildRectangleFromLine(line: String): Option[Rectangle] = {
    //#1 @ 393,863: 11x29
    val rectangleRegex = "#(.*?) @ (.*?),(.*?): (.*?)x(.*)".r
    line match {
      case rectangleRegex(id, left, top, width, height) => Some(Rectangle(id.toInt, left.toInt, top.toInt, width.toInt, height.toInt))
      case _ => None
    }
  }

  override def part1(seq: Seq[String]) = {
    val rectangles = seq.map(buildRectangleFromLine).flatten.toSet
    val overlaps: mutable.Map[(Int, Int), Int] = mutable.Map.empty.withDefaultValue(0) //allows to modify value without key

    //Stolen algorithm from Internet.
    for {
      Rectangle(_, left, top, width, height) <- rectangles
      x <- left until (left + width)
      y <- top until (top + height)
    } {
      val pos = (x, y)
      overlaps(pos) += 1
    }

    overlaps.values.count(_ >= 2)
  }


  override def part2(seq: Seq[String]) = {
    val rectangles = seq.map(buildRectangleFromLine).flatten.toSet
    val overlaps: mutable.Map[(Int, Int), Rectangle] = mutable.Map.empty
    val nonOverlaps: mutable.Set[Rectangle] = rectangles.to[mutable.Set]

    for {
      rect@Rectangle(_, left, top, width, height) <- rectangles
      x <- left until (left + width)
      y <- top until (top + height)
    } {
      val pos = (x, y)
      if (overlaps.contains(pos)) {
        nonOverlaps -= rect
        nonOverlaps -= overlaps(pos)
      }
      else
        overlaps(pos) = rect
    }

    nonOverlaps.head.id
  }

  override def getFileName = "day3.txt"
}
