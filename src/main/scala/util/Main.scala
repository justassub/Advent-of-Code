package util

trait Main[T, R1, R2] extends App {
  def getFileName: String
  def getPackage: String

  implicit val file = s"./src/main/resources/$getPackage/$getFileName"
  lazy val seqInt = FileReader.readAndMapToInt
  lazy val seqString = FileReader.readResource

  def part1(seq: Seq[T]): R1

  def part2(seq: Seq[T]): R2
}
