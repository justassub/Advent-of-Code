package year2018

import util.FileReader

object Day3 extends App {
  lazy implicit val file = "./src/main/resources/day1.txt"
  lazy implicit val seq = FileReader.readAndMapToInt

  case class Rectangle(id: Int, left: Int, top: Int, width: Int, height: Int)

  def part1(implicit seq: Seq[Int]): Int = seq.sum

  // def parseRectangles(input: String): Seq[Rectangle] = input.lines.map(parseRectangle).toSeq


}
