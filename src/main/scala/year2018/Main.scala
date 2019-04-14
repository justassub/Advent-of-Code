package year2018

import util.FileReader

trait Main[T, R1, R2] extends App {
  def getFileName: String

  implicit val file = s"./src/main/resources/$getFileName"
  lazy val seqInt = FileReader.readAndMapToInt
  lazy val seqString = FileReader.readResource

  def part1(seq: Seq[T]): R1

  def part2(seq: Seq[T]): R2
}
